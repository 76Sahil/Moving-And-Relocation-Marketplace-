const API_BASE_URL = "http://localhost:8080/api";

export async function createMovingRequest(requestData) {
  const response = await fetch(`${API_BASE_URL}/moving-requests`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestData),
  });

  if (!response.ok) {
    throw new Error("Failed to create moving request");
  }

  return response.json();
}

export async function getMovingRequests() {
  const response = await fetch(`${API_BASE_URL}/moving-requests`);

  if (!response.ok) {
    throw new Error("Failed to fetch moving requests");
  }

  return response.json();
}

export async function getMovingRequestById(id) {
  const response = await fetch(`${API_BASE_URL}/moving-requests/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch moving request");
  }

  return response.json();
}

export async function updateMovingRequest(id, requestData) {
  const response = await fetch(`${API_BASE_URL}/moving-requests/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestData),
  });

  if (!response.ok) {
    throw new Error("Failed to update moving request");
  }

  return response.json();
}

export async function deleteMovingRequest(id) {
  const response = await fetch(`${API_BASE_URL}/moving-requests/${id}`, {
    method: "DELETE",
  });

  if (!response.ok) {
    throw new Error("Failed to delete moving request");
  }

  return true;
}