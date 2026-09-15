import { Link } from "react-router-dom";

export default function Footer() {
  return (
    <footer className="footer">
      <div>
        <h2>MOVE<span>.</span></h2>
        <p>Move smarter. Move better. Move with confidence.</p>
      </div>

      <div className="footer-links">
        <Link to="/">Home</Link>
        <Link to="/providers">Providers</Link>
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link>
      </div>

      <p className="copyright">Copyright 2026 MOVE. All rights reserved.</p>
    </footer>
  );
}
