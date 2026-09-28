import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { registerUser } from "../services/api";
import "../styles/Auth.css";

export default function Register() {
  const navigate = useNavigate();
  const [form, setForm] = useState({ username: "", password: "", role: "CUSTOMER" });
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setLoading(true);
    try {
      await registerUser(form);
      navigate("/login");
    } catch (err) {
      setError(err.response?.data?.message || "Unable to create account.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className="auth-page">
      <div className="auth-box">
        <p className="auth-label">JOIN MOVE</p>
        <h1>Your next chapter<br /><span>starts here.</span></h1>
        <p className="auth-subtitle">Create your account and plan your move with confidence.</p>

        <form onSubmit={handleSubmit}>
          <input type="text" placeholder="Full name" value={form.username} onChange={(e) => setForm({ ...form, username: e.target.value })} required />
          <input type="email" placeholder="Email address" value={form.username} onChange={(e) => setForm({ ...form, username: e.target.value })} required />
          <input type="password" placeholder="Create password" value={form.password} onChange={(e) => setForm({ ...form, password: e.target.value })} required />
          {error && <p>{error}</p>}
          <button type="submit" disabled={loading}>{loading ? "Creating..." : "Create Account →"}</button>
        </form>

        <p className="auth-switch">
          Already have an account? <Link to="/login">Sign in</Link>
        </p>
      </div>
    </main>
  );
}
