import { Link, useNavigate } from "react-router-dom";
import "../styles/Request.css";

export default function CreateRequest() {
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate("/quotes");
  };

  return (
    <main className="request-page">
      <div className="request-box">
        <p className="auth-label">PLAN YOUR MOVE</p>

        <h1>
          Tell us about<br />
          <span>your move.</span>
        </h1>

        <form onSubmit={handleSubmit}>
          <input type="text" placeholder="Moving from" required />
          <input type="text" placeholder="Moving to" required />
          <input type="date" required />
          <textarea placeholder="Tell us anything else..." />

          <button type="submit">
            Find Moving Partners →
          </button>
        </form>

        <Link to="/dashboard" className="request-back">
          ← Back to Dashboard
        </Link>
      </div>
    </main>
  );
}
