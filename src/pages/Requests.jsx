// import { Link } from "react-router-dom";
// import "../styles/Requests.css";

// const requests = [
//   {
//     id: "MR-1024",
//     origin: "Pune",
//     destination: "Mumbai",
//     date: "28 Sep 2026",
//     status: "Searching",
//     budget: "₹8,500"
//   },
//   {
//     id: "MR-1018",
//     origin: "Delhi",
//     destination: "Bangalore",
//     date: "05 Oct 2026",
//     status: "Quotes Received",
//     budget: "₹18,000"
//   },
//   {
//     id: "MR-1007",
//     origin: "Mumbai",
//     destination: "Nashik",
//     date: "12 Oct 2026",
//     status: "Completed",
//     budget: "₹6,200"
//   }
// ];

// export default function Requests() {
//   return (
//     <main className="requests-page">
//       <div className="requests-header">
//         <div>
//           <p className="section-label">YOUR JOURNEY</p>
//           <h1>Moving <span>requests.</span></h1>
//           <p>Track every relocation from one place.</p>
//         </div>

//         <Link to="/create-request" className="new-request">
//           + New Request
//         </Link>
//       </div>

//       <div className="requests-grid">
//         {requests.map((request) => (
//           <article className="request-card" key={request.id}>
//             <div className="request-card-top">
//               <span>{request.id}</span>
//               <b>{request.status}</b>
//             </div>

//             <div className="route">
//               <div>
//                 <small>FROM</small>
//                 <strong>{request.origin}</strong>
//               </div>

//               <div className="route-line">→</div>

//               <div>
//                 <small>TO</small>
//                 <strong>{request.destination}</strong>
//               </div>
//             </div>

//             <div className="request-meta">
//               <span>Move date<br /><b>{request.date}</b></span>
//               <span>Budget<br /><b>{request.budget}</b></span>
//             </div>

//             <Link to="/providers" className="request-action">
//               View Providers →
//             </Link>
//           </article>
//         ))}
//       </div>
//     </main>
//   );
// }


import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../styles/Requests.css";
import { getMovingRequests } from "../services/api";

export default function Requests() {
  const [requests, setRequests] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    getMovingRequests()
      .then((data) => {
        setRequests(data);
      })
      .catch(() => {
        setError("Unable to load your moving requests.");
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  return (
    <main className="requests-page">
      <div className="requests-header">
        <div>
          <p className="section-label">YOUR JOURNEY</p>
          <h1>
            Moving <span>requests.</span>
          </h1>
          <p>Track every relocation from one place.</p>
        </div>

        <Link to="/create-request" className="new-request">
          + New Request
        </Link>
      </div>

      {loading && <p>Loading requests...</p>}

      {error && <p className="error-message">{error}</p>}

      {!loading && !error && requests.length === 0 && (
        <p>No moving requests found.</p>
      )}

      {!loading && !error && requests.length > 0 && (
        <div className="requests-grid">
          {requests.map((request) => (
            <article className="request-card" key={request.id}>
              <div className="request-card-top">
                <span>MR-{request.id}</span>
                <b>{request.propertyType}</b>
              </div>

              <div className="route">
                <div>
                  <small>FROM</small>
                  <strong>{request.origin}</strong>
                </div>

                <div className="route-line">→</div>

                <div>
                  <small>TO</small>
                  <strong>{request.destination}</strong>
                </div>
              </div>

              <div className="request-meta">
                <span>
                  Move date
                  <br />
                  <b>{request.movingDate}</b>
                </span>

                <span>
                  Service
                  <br />
                  <b>{request.serviceNeeds}</b>
                </span>
              </div>

              <Link to="/providers" className="request-action">
                View Providers →
              </Link>
            </article>
          ))}
        </div>
      )}
    </main>
  );
}