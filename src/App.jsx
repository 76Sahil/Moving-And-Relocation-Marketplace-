import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import Providers from "./pages/Providers";
import CreateRequest from "./pages/CreateRequest";
import Requests from "./pages/Requests";
import ProviderDetails from "./pages/ProviderDetails";
import Quotes from "./pages/Quotes";

function App() {
  return (
    <BrowserRouter>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/providers" element={<Providers />} />
        <Route path="/create-request" element={<CreateRequest />} />
        <Route path="/requests" element={<Requests />} />
        <Route path="/provider/:id" element={<ProviderDetails />} />
        <Route path="/quotes" element={<Quotes />} />
      </Routes>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
