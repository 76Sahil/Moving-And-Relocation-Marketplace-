import { Link } from "react-router-dom";

const providers = [
  { id: "elite-movers", name: "Elite Movers", rating: "4.9", jobs: "1,240+", price: "₹4,999" },
  { id: "urbanshift", name: "UrbanShift Logistics", rating: "4.8", jobs: "980+", price: "₹5,499" },
  { id: "movecraft", name: "MoveCraft", rating: "4.9", jobs: "1,560+", price: "₹6,200" }
];

export default function ProviderShowcase() {
  return (
    <section className="providers-section">
      <p className="section-label">TRUSTED PROFESSIONALS</p>
      <h2>Find your perfect <span>moving partner.</span></h2>

      <div className="provider-grid">
        {providers.map((provider) => (
          <div className="provider-card" key={provider.id}>
            <div className="provider-top">
              <div className="provider-icon">{provider.name[0]}</div>
              <span>VERIFIED</span>
            </div>

            <h3>{provider.name}</h3>
            <p>Professional relocation services</p>

            <div className="provider-info">
              <strong>★ {provider.rating}</strong>
              <span>{provider.jobs} moves</span>
            </div>

            <div className="provider-bottom">
              <strong>From {provider.price}</strong>
              <Link to={`/provider/${provider.id}`}>View →</Link>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}
