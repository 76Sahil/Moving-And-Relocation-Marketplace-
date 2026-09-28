import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import api from "../services/api";
import "../styles/Quotes.css";

export default function Quotes() {
  const { state } = useLocation();
  const request = state?.movingRequest;

  const [pricing, setPricing] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    if (!request?.id) {
      setLoading(false);
      return;
    }

    api.get("/pricing")
      .then(({ data }) => {
        const result = data.find(
          (item) => item.movingRequest?.id === request.id ||
                    item.movingRequestId === request.id
        );
        setPricing(result || null);
      })
      .catch((err) => {
        setError(err.response?.data?.message || "Unable to load pricing.");
      })
      .finally(() => setLoading(false));
  }, [request?.id]);

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

      {loading && <p>Loading pricing...</p>}
      {error && <p>{error}</p>}

      {!loading && !error && !pricing && (
        <p>No pricing has been generated for this request yet.</p>
      )}

      {pricing && (
        <section className="quotes-grid">
          <article className="quote-card">
            <div className="quote-top">
              <div className="quote-avatar">₹</div>
              <span>ESTIMATE</span>
            </div>

            <h2>Moving estimate</h2>
            <p>Pricing for moving request #{request.id}</p>

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
          </article>
        </section>
      )}
    </main>
  );
}
