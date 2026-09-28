import { useEffect, useState } from "react";
import { getInventory } from "../services/api";

export function useInventory() {
  const [inventory, setInventory] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    getInventory()
      .then(setInventory)
      .catch((err) => setError(err.response?.data?.message || "Unable to load inventory."))
      .finally(() => setLoading(false));
  }, []);

  return { inventory, loading, error };
}
