import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getMovingRequests, getQuotations } from "../services/api";
import "../styles/Quotes.css";

export default function Quotes() {
  const [quotes, setQuotes] = useState([]);
  const [request, setRequest] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const loadQuotes = async () => {
      try {
        const [requests, quotations] = await Promise.all([
          getMovingRequests(),
          getQuotations(),
        ]);

        const latestRequest = requests[requests.length - 1];

        if (!latestRequest) {
          setQuotes([]);
          return;
        }

        setRequest(latestRequest);

        const matchingQuotes = quotations.filter(
          (quote) => quote.movingRequestId === latestRequest.id
        );

        setQuotes(matchingQuotes);
      } catch (err) {
        setError("Unable to load your quotes. Please try again.");
      } finally {
        setLoading(false);
      }
    };

    loadQuotes();
  }, []);

  return (
    <main className="quotes-page">
      <div className="quotes-header">
        <div>
          <p className="section-label">YOUR QUOTES</p>

          <h1>
            Choose your <span>move.</span>
          </h1>

          <p>Compare quotations for your moving request.</p>
        </div>

        <Link to="/create-request" className="quotes-back">
          ← Edit Request
        </Link>
      </div>

      {request && (
        <div className="quote-route">
          <span>{request.origin}</span>

          <strong>→</strong>

          <span>{request.destination}</span>

          <small>{request.movingDate}</small>
        </div>
      )}

      {loading && <p>Loading quotes...</p>}

      {error && <p className="error-message">{error}</p>}

      {!loading && !error && quotes.length === 0 && (
        <p>No quotes available for your latest moving request.</p>
      )}

      {!loading && !error && quotes.length > 0 && (
        <section className="quotes-grid">
          {quotes.map((quote) => (
            <article className="quote-card" key={quote.id}>
              <div className="quote-top">
                <div className="quote-avatar">Q</div>

                <span>{quote.status || "PENDING"}</span>
              </div>

              <h2>Moving Quotation</h2>

              <p>
                Quotation #{quote.id} for your moving request.
              </p>

              <div className="quote-rating">
                <strong>Request #{quote.movingRequestId}</strong>
                <span>Quotation details</span>
              </div>

              <div className="quote-details">
                <div>
                  <small>PROPERTY TYPE</small>
                  <b>{request?.propertyType || "N/A"}</b>
                </div>

                <div>
                  <small>QUOTATION AMOUNT</small>
                  <b>₹{quote.amount}</b>
                </div>
              </div>

              <div className="quote-details">
                <div>
                  <small>SERVICE NEEDED</small>
                  <b>{request?.serviceNeeds || "N/A"}</b>
                </div>

                <div>
                  <small>STATUS</small>
                  <b>{quote.status || "PENDING"}</b>
                </div>
              </div>

              <Link
                to={`/provider/quotation-${quote.id}`}
                className="quote-button"
              >
                View Quote →
              </Link>
            </article>
          ))}
        </section>
      )}
    </main>
  );
}