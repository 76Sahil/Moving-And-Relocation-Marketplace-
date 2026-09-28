import { useState } from "react";
import { createBooking } from "../services/api";

export function useCreateBooking() {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const bookMove = async (data) => {
    setLoading(true);
    setError("");
    try {
      return await createBooking(data);
    } catch (err) {
      setError(err.response?.data?.message || "Unable to create booking.");
      return null;
    } finally {
      setLoading(false);
    }
  };

  return { bookMove, loading, error };
}
