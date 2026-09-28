import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import { getQuotations } from "../services/api";
import "../styles/Quotes.css";

export default function Quotes() {
  const { state } = useLocation();
  const request = state?.movingRequest;

  const [quotes, setQuotes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    getQuotations()
      .then((data) => {
        const filtered = request?.id
          ? data.filter((quote) => quote.movingRequestId === request.id)
          : data;
        setQuotes(filtered);
      })
      .catch((err) => {
        setError(err.response?.data?.message || "Unable to load quotations.");
      })
      .finally(() => setLoading(false));
  }, [request?.id]);

  return (
    <main className="quotes-page">
      <div className="quotes-header">
        <div>
          <p className="section-label">YOUR QUOTES</p>
          <h1>Choose your <span>move.</span></h1>
          <p>Compare quotations for your moving request.</p>
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

      {loading && <p>Loading quotations...</p>}
      {error && <p>{error}</p>}

      {!loading && !error && quotes.length === 0 && (
        <p>No quotations available for this request yet.</p>
      )}

      <section className="quotes-grid">
        {quotes.map((quote) => (
          <article className="quote-card" key={quote.id}>
            <div className="quote-top">
              <div className="quote-avatar">₹</div>
              <span>{quote.status}</span>
            </div>

            <h2>Quotation #{quote.id}</h2>
            <p>Moving request #{quote.movingRequestId}</p>

            <div className="quote-details">
              <div>
                <small>STATUS</small>
                <b>{quote.status}</b>
              </div>
              <div>
                <small>QUOTED AMOUNT</small>
                <b>₹{quote.amount}</b>
              </div>
            </div>
          </article>
        ))}
      </section>
    </main>
  );
}
