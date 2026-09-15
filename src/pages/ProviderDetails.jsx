import { Link, useParams } from "react-router-dom";
import "../styles/ProviderDetails.css";

const providers = {
  "elite-movers": {
    name: "Elite Movers",
    initial: "E",
    rating: "4.9",
    reviews: "328",
    moves: "1,240+",
    price: "₹4,999",
    location: "Pune • Mumbai • Maharashtra",
    description: "Premium relocation specialists focused on safe handling, transparent pricing and a stress-free moving experience."
  },
  "urbanshift": {
    name: "UrbanShift Logistics",
    initial: "U",
    rating: "4.8",
    reviews: "241",
    moves: "980+",
    price: "₹5,499",
    location: "Mumbai • Pune • Nashik",
    description: "Reliable relocation services with professional packing, transportation and careful delivery."
  },
  "movecraft": {
    name: "MoveCraft",
    initial: "M",
    rating: "4.9",
    reviews: "416",
    moves: "1,560+",
    price: "₹6,200",
    location: "Pune • Bangalore • Delhi",
    description: "End-to-end moving solutions designed for modern homes, offices and long-distance relocations."
  }
};

export default function ProviderDetails() {
  const { id } = useParams();
  const provider = providers[id] || providers["elite-movers"];

  return (
    <main className="provider-details">
      <Link to="/providers" className="back-link">← Back to providers</Link>

      <section className="provider-hero-card">
        <div className="provider-avatar">{provider.initial}</div>

        <div className="provider-main">
          <p className="section-label">VERIFIED MOVING PARTNER</p>
          <h1>{provider.name}</h1>
          <p className="provider-location">{provider.location}</p>
          <p className="provider-description">{provider.description}</p>

          <div className="provider-actions">
            <Link to="/create-request" className="gold-button">
              Request a Quote →
            </Link>
            <button className="outline-button">Save Provider</button>
          </div>
        </div>

        <div className="provider-rating">
          <strong>★ {provider.rating}</strong>
          <span>{provider.reviews} reviews</span>
        </div>
      </section>

      <section className="provider-stats">
        <div><strong>{provider.moves}</strong><span>Moves Completed</span></div>
        <div><strong>{provider.rating}/5</strong><span>Customer Rating</span></div>
        <div><strong>{provider.price}</strong><span>Starting Price</span></div>
        <div><strong>24/7</strong><span>Support</span></div>
      </section>

      <section className="provider-info-grid">
        <div>
          <p className="section-label">SERVICES</p>
          <h2>Everything you need<br /><span>to move better.</span></h2>
        </div>

        <div className="service-list">
          <div>01 <b>Home Relocation</b></div>
          <div>02 <b>Office Relocation</b></div>
          <div>03 <b>Packing & Unpacking</b></div>
          <div>04 <b>Furniture Handling</b></div>
        </div>
      </section>
    </main>
  );
}
