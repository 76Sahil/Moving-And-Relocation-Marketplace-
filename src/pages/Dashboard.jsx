import { Link } from "react-router-dom";
import "../styles/Dashboard.css";

export default function Dashboard() {
  return (
    <main className="dashboard-page">
      <div className="dashboard-header">
        <div>
          <p className="section-label">YOUR SPACE</p>
          <h1>Welcome <span>back.</span></h1>
          <p>Manage your relocation journey from one place.</p>
        </div>

        <Link to="/create-request" className="dashboard-button">
          + Create Move
        </Link>
      </div>

      <section className="dashboard-stats">
        <div><strong>02</strong><span>Active Requests</span></div>
        <div><strong>05</strong><span>Quotes Received</span></div>
        <div><strong>08</strong><span>Saved Providers</span></div>
      </section>

      <section className="dashboard-grid">
        <div className="dashboard-panel">
          <div className="panel-heading">
            <div>
              <p className="section-label">RECENT ACTIVITY</p>
              <h2>Your <span>moves.</span></h2>
            </div>
            <Link to="/requests">View all →</Link>
          </div>

          <div className="move-item">
            <div>
              <small>MR-1024</small>
              <h3>Pune → Mumbai</h3>
              <p>28 Sep 2026</p>
            </div>
            <b>Searching</b>
          </div>

          <div className="move-item">
            <div>
              <small>MR-1018</small>
              <h3>Delhi → Bangalore</h3>
              <p>05 Oct 2026</p>
            </div>
            <b>Quotes Received</b>
          </div>
        </div>

        <div className="dashboard-panel quick-panel">
          <p className="section-label">QUICK ACTION</p>
          <h2>Ready for your<br /><span>next move?</span></h2>
          <p>Compare trusted professionals and find the right partner for your relocation.</p>
          <Link to="/providers" className="dashboard-outline">
            Explore Providers →
          </Link>
        </div>
      </section>
    </main>
  );
}
