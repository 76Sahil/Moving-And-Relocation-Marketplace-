import { useEffect, useState } from "react";
import { getSchedules, getTracking, createClaim } from "./api";

export function useSchedules() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  useEffect(() => {
    getSchedules().then(setData).catch(e => setError(e.response?.data?.message || "Unable to load schedules.")).finally(() => setLoading(false));
  }, []);
  return { schedules: data, loading, error };
}

export function useTracking() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  useEffect(() => {
    getTracking().then(setData).catch(e => setError(e.response?.data?.message || "Unable to load tracking.")).finally(() => setLoading(false));
  }, []);
  return { tracking: data, loading, error };
}

export function useClaims() {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const submitClaim = async (data) => {
    setLoading(true);
    setError("");
    try { return await createClaim(data); }
    catch (e) { setError(e.response?.data?.message || "Unable to create claim."); return null; }
    finally { setLoading(false); }
  };
  return { submitClaim, loading, error };
}
