import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api",
  headers: {
    "Content-Type": "application/json",
  },
});

export const createMovingRequest = async (data) =>
  (await api.post("/moving-requests", data)).data;

export const getMovingRequests = async () =>
  (await api.get("/moving-requests")).data;

export const getMovingRequest = async (id) =>
  (await api.get(`/moving-requests/${id}`)).data;

export const createQuotation = async (data) =>
  (await api.post("/quotations", data)).data;

export const getQuotations = async () =>
  (await api.get("/quotations")).data;

export const createBooking = async (data) =>
  (await api.post("/bookings", data)).data;

export const createClaim = async (data) =>
  (await api.post("/claims", data)).data;

export const getInventory = async () =>
  (await api.get("/inventory")).data;

export const getSchedules = async () =>
  (await api.get("/schedules")).data;

export const getTracking = async () =>
  (await api.get("/tracking")).data;

export default api;
