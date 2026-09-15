import { Link } from "react-router-dom";
import "../styles/Auth.css";

export default function Login() {
  return (
    <main className="auth-page">
      <div className="auth-box">
        <p className="auth-label">WELCOME BACK</p>
        <h1>Move starts<br /><span>here.</span></h1>
        <p className="auth-subtitle">Sign in to manage your relocation journey.</p>

        <form>
          <input type="email" placeholder="Email address" required />
          <input type="password" placeholder="Password" required />
          <button type="submit">Sign In →</button>
        </form>

        <p className="auth-switch">
          New to MOVE? <Link to="/register">Create an account</Link>
        </p>
      </div>
    </main>
  );
}
