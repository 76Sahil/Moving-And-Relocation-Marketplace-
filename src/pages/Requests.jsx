import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getMovingRequests } from "../services/api";
import "../styles/Requests.css";

export default function Requests() {
  const [requests, setRequests] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    getMovingRequests()
      .then(setRequests)
      .catch((err) => setError(err.response?.data?.message || "Unable to load requests."))
      .finally(() => setLoading(false));
  }, []);

  return (
    <main className="requests-page">
      <div className="requests-header">
        <div>
          <p className="section-label">YOUR JOURNEY</p>
          <h1>Moving <span>requests.</span></h1>
          <p>Track every relocation from one place.</p>
        </div>
        <Link to="/create-request" className="new-request">+ New Request</Link>
      </div>

      {loading && <p>Loading requests...</p>}
      {error && <p>{error}</p>}

      {!loading && !error && requests.length === 0 && (
        <p>No moving requests found.</p>
      )}

      <div className="requests-grid">
        {requests.map((request) => (
          <article className="request-card" key={request.id}>
            <div className="request-card-top">
              <span>MR-{request.id}</span>
              <b>Active</b>
            </div>

            <div className="route">
              <div><small>FROM</small><strong>{request.origin}</strong></div>
              <div className="route-line">?</div>
              <div><small>TO</small><strong>{request.destination}</strong></div>
            </div>

            <div className="request-meta">
              <span>Move date<br /><b>{request.movingDate}</b></span>
              <span>Property<br /><b>{request.propertyType}</b></span>
            </div>

            <Link to="/providers" className="request-action">
              View Providers ?
            </Link>
          </article>
        ))}
      </div>
    </main>
  );
}
