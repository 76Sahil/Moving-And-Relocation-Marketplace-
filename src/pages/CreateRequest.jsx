// import { Link, useNavigate } from "react-router-dom";
// import "../styles/Request.css";

// export default function CreateRequest() {
//   const navigate = useNavigate();

//   const handleSubmit = (e) => {
//     e.preventDefault();
//     navigate("/quotes");
//   };

//   return (
//     <main className="request-page">
//       <div className="request-box">
//         <p className="auth-label">PLAN YOUR MOVE</p>

//         <h1>
//           Tell us about<br />
//           <span>your move.</span>
//         </h1>

//         <form onSubmit={handleSubmit}>
//           <input type="text" placeholder="Moving from" required />
//           <input type="text" placeholder="Moving to" required />
//           <input type="date" required />
//           <textarea placeholder="Tell us anything else..." />

//           <button type="submit">
//             Find Moving Partners →
//           </button>
//         </form>

//         <Link to="/dashboard" className="request-back">
//           ← Back to Dashboard
//         </Link>
//       </div>
//     </main>
//   );
// }


import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../styles/Request.css";
import { createMovingRequest } from "../services/api";

export default function CreateRequest() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    origin: "",
    destination: "",
    propertyType: "House",
    movingDate: "",
    serviceNeeds: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData((previousData) => ({
      ...previousData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    setLoading(true);
    setError("");

    try {
      await createMovingRequest(formData);

      navigate("/quotes");
    } catch (err) {
      setError("Unable to create your moving request. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className="request-page">
      <div className="request-box">
        <p className="auth-label">PLAN YOUR MOVE</p>

        <h1>
          Tell us about
          <br />
          <span>your move.</span>
        </h1>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="origin"
            placeholder="Moving from"
            value={formData.origin}
            onChange={handleChange}
            required
          />

          <input
            type="text"
            name="destination"
            placeholder="Moving to"
            value={formData.destination}
            onChange={handleChange}
            required
          />

          <select
            name="propertyType"
            value={formData.propertyType}
            onChange={handleChange}
            required
          >
            <option value="House">House</option>
            <option value="Apartment">Apartment</option>
            <option value="Office">Office</option>
            <option value="Other">Other</option>
          </select>

          <input
            type="date"
            name="movingDate"
            value={formData.movingDate}
            onChange={handleChange}
            required
          />

          <textarea
            name="serviceNeeds"
            placeholder="Tell us anything else..."
            value={formData.serviceNeeds}
            onChange={handleChange}
            required
          />

          {error && <p className="error-message">{error}</p>}

          <button type="submit" disabled={loading}>
            {loading ? "Creating Request..." : "Find Moving Partners →"}
          </button>
        </form>

        <Link to="/dashboard" className="request-back">
          ← Back to Dashboard
        </Link>
      </div>
    </main>
  );
}