import { Link } from "react-router-dom";
import "../styles/Navbar.css";

export default function Navbar() {
  return (
    <nav className="navbar">
      <Link to="/" className="logo">MOVE<span>.</span></Link>

      <div className="nav-links">
        <Link to="/">Home</Link>
        <Link to="/providers">Providers</Link>
        <Link to="/dashboard">Dashboard</Link>
      </div>

      <div className="nav-actions">
        <Link to="/login" className="nav-login">Login</Link>
        <Link to="/register" className="nav-register">Get Started</Link>
      </div>
    </nav>
  );
}
