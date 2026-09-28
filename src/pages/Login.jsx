import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../services/api";
import "../styles/Auth.css";

export default function Login() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setLoading(true);
    try {
      await loginUser(username, password);
      navigate("/");
    } catch (err) {
      setError(err.response?.data?.message || "Invalid username or password.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className="auth-page">
      <div className="auth-box">
        <p className="auth-label">WELCOME BACK</p>
        <h1>Move starts<br /><span>here.</span></h1>
        <p className="auth-subtitle">Sign in to manage your relocation journey.</p>

        <form onSubmit={handleSubmit}>
          <input type="text" placeholder="Email address" value={username} onChange={(e) => setUsername(e.target.value)} required />
          <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
          {error && <p>{error}</p>}
          <button type="submit" disabled={loading}>{loading ? "Signing In..." : "Sign In →"}</button>
        </form>

        <p className="auth-switch">
          New to MOVE? <Link to="/register">Create an account</Link>
        </p>
      </div>
    </main>
  );
}
