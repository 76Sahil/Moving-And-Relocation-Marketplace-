import { Link } from "react-router-dom";
import "../styles/Auth.css";

export default function Register() {
  return (
    <main className="auth-page">
      <div className="auth-box">
        <p className="auth-label">JOIN MOVE</p>
        <h1>Your next chapter<br /><span>starts here.</span></h1>
        <p className="auth-subtitle">Create your account and plan your move with confidence.</p>

        <form>
          <input type="text" placeholder="Full name" required />
          <input type="email" placeholder="Email address" required />
          <input type="password" placeholder="Create password" required />
          <button type="submit">Create Account →</button>
        </form>

        <p className="auth-switch">
          Already have an account? <Link to="/login">Sign in</Link>
        </p>
      </div>
    </main>
  );
}
