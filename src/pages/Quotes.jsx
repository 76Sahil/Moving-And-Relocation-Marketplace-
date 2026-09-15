import { Link } from "react-router-dom";
import "../styles/Quotes.css";

const quotes = [
  { provider: "Elite Movers", rating: "4.9", price: "₹7,800", time: "1–2 Days", badge: "BEST VALUE", id: "elite-movers" },
  { provider: "UrbanShift Logistics", rating: "4.8", price: "₹8,500", time: "1–2 Days", badge: "FASTEST", id: "urbanshift" },
  { provider: "MoveCraft", rating: "4.9", price: "₹9,200", time: "2 Days", badge: "PREMIUM", id: "movecraft" }
];

export default function Quotes() {
  return (
    <main className="quotes-page">
      <div className="quotes-header">
        <div>
          <p className="section-label">YOUR QUOTES</p>
          <h1>Choose your <span>move.</span></h1>
          <p>Compare verified providers and select the right option.</p>
        </div>
        <Link to="/create-request" className="quotes-back">← Edit Request</Link>
      </div>

      <div className="quote-route">
        <span>PUNE</span>
        <strong>→</strong>
        <span>MUMBAI</span>
        <small>28 SEP 2026</small>
      </div>

      <section className="quotes-grid">
        {quotes.map((quote) => (
          <article className="quote-card" key={quote.id}>
            <div className="quote-top">
              <div className="quote-avatar">{quote.provider[0]}</div>
              <span>{quote.badge}</span>
            </div>

            <h2>{quote.provider}</h2>
            <p>Verified professional moving partner</p>

            <div className="quote-rating">
              <strong>★ {quote.rating}</strong>
              <span>Verified reviews</span>
            </div>

            <div className="quote-details">
              <div><small>ESTIMATED TIME</small><b>{quote.time}</b></div>
              <div><small>STARTING FROM</small><b>{quote.price}</b></div>
            </div>

            <Link to={`/provider/${quote.id}`} className="quote-button">
              View Provider →
            </Link>
          </article>
        ))}
      </section>
    </main>
  );
}
