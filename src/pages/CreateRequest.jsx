import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { createMovingRequest } from "../services/api";
import "../styles/Request.css";

export default function CreateRequest() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    origin: "",
    destination: "",
    propertyType: "",
    movingDate: "",
    serviceNeeds: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setLoading(true);

    try {
      const request = await createMovingRequest(form);
      navigate("/quotes", { state: { movingRequest: request } });
    } catch (err) {
      setError(
        err.response?.data?.message ||
        "Unable to create your moving request."
      );
    } finally {
      setLoading(false);
    }
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
          <input
            name="origin"
            type="text"
            placeholder="Moving from"
            value={form.origin}
            onChange={handleChange}
            required
          />

          <input
            name="destination"
            type="text"
            placeholder="Moving to"
            value={form.destination}
            onChange={handleChange}
            required
          />

          <select
            name="propertyType"
            value={form.propertyType}
            onChange={handleChange}
            required
          >
            <option value="">Select property type</option>
            <option value="1BHK">1 BHK</option>
            <option value="2BHK">2 BHK</option>
            <option value="3BHK">3 BHK</option>
            <option value="4BHK">4 BHK</option>
            <option value="VILLA">Villa</option>
            <option value="OFFICE">Office</option>
          </select>

          <input
            name="movingDate"
            type="date"
            value={form.movingDate}
            onChange={handleChange}
            required
          />

          <textarea
            name="serviceNeeds"
            placeholder="Tell us what services you need..."
            value={form.serviceNeeds}
            onChange={handleChange}
            required
          />

          {error && <p>{error}</p>}

          <button type="submit" disabled={loading}>
            {loading ? "Creating..." : "Find Moving Partners ?"}
          </button>
        </form>

        <Link to="/dashboard" className="request-back">
          ? Back to Dashboard
        </Link>
      </div>
    </main>
  );
}
