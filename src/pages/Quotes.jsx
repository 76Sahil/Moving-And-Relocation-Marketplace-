import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import api from "../services/api";
import { createBooking } from "../services/api";
import "../styles/Quotes.css";

export default function Quotes() {
  const { state } = useLocation();
  const request = state?.movingRequest;

  const [pricing, setPricing] = useState(null);
  const [quotation, setQuotation] = useState(null);
  const [loading, setLoading] = useState(true);
  const [bookingLoading, setBookingLoading] = useState(false);
  const [error, setError] = useState("");
  const [bookingMessage, setBookingMessage] = useState("");

  useEffect(() => {
    if (!request?.id) {
      setLoading(false);
      return;
    }

    Promise.all([
      api.get("/pricing"),
      api.get("/quotations"),
    ])
      .then(([pricingResponse, quotationResponse]) => {
        const pricingResult = pricingResponse.data.find(
          (item) =>
            item.movingRequest?.id === request.id ||
            item.movingRequestId === request.id
        );

        const quotationResult = quotationResponse.data.find(
          (item) => item.movingRequestId === request.id
        );

        setPricing(pricingResult || null);
        setQuotation(quotationResult || null);
      })
      .catch((err) => {
        setError(err.response?.data?.message || "Unable to load quote details.");
      })
      .finally(() => setLoading(false));
  }, [request?.id]);

  const handleBooking = async () => {
    if (!request?.id || !quotation?.id) return;

    setBookingLoading(true);
    setBookingMessage("");
    setError("");

    try {
      await createBooking({
        movingRequestId: request.id,
        quotationId: quotation.id,
        bookingDate: request.movingDate,
        status: "PENDING",
      });

      setBookingMessage("Booking request created successfully.");
    } catch (err) {
      setError(err.response?.data?.message || "Unable to create booking.");
    } finally {
      setBookingLoading(false);
    }
  };

  return (
    <main className="quotes-page">
      <div className="quotes-header">
        <div>
          <p className="section-label">MOVE PRICING</p>
          <h1>Your <span>estimate.</span></h1>
          <p>Review the pricing for your moving request.</p>
        </div>
        <Link to="/create-request" className="quotes-back">← Edit Request</Link>
      </div>

      {request && (
        <div className="quote-route">
          <span>{request.origin.toUpperCase()}</span>
          <strong>→</strong>
          <span>{request.destination.toUpperCase()}</span>
          <small>{request.movingDate}</small>
        </div>
      )}

      {loading && <p>Loading quote details...</p>}
      {error && <p>{error}</p>}
      {bookingMessage && <p>{bookingMessage}</p>}

      {!loading && !error && !pricing && !quotation && (
        <p>No quote has been generated for this request yet.</p>
      )}

      {(pricing || quotation) && (
        <section className="quotes-grid">
          <article className="quote-card">
            <div className="quote-top">
              <div className="quote-avatar">₹</div>
              <span>ESTIMATE</span>
            </div>

            <h2>Moving estimate</h2>
            <p>Pricing for moving request #{request.id}</p>

            {pricing && (
              <>
                <div className="quote-details">
                  <div>
                    <small>BASE PRICE</small>
                    <b>₹{pricing.basePrice}</b>
                  </div>
                  <div>
                    <small>ADDITIONAL CHARGES</small>
                    <b>₹{pricing.additionalCharges}</b>
                  </div>
                </div>

                <div className="quote-details">
                  <div>
                    <small>TOTAL PRICE</small>
                    <b>₹{pricing.totalPrice}</b>
                  </div>
                </div>
              </>
            )}

            {quotation && (
              <button
                type="button"
                onClick={handleBooking}
                disabled={bookingLoading}
              >
                {bookingLoading ? "Booking..." : "Book This Move →"}
              </button>
            )}
          </article>
        </section>
      )}
    </main>
  );
}
