import "../styles/Home.css";
import "../styles/Sections.css";
import "../styles/Providers.css";
import MovingScene from "../components/3d/MovingScene";
import Stats from "../components/Stats";
import HowItWorks from "../components/HowItWorks";
import ProviderShowcase from "../components/ProviderShowcase";
import ScrollAnimations from "../components/ScrollAnimations";

function Home() {
  return (
    <main className="home">
      <ScrollAnimations />

      <section className="hero">
        <div className="hero-content">
          <p className="eyebrow">PREMIUM MOVING & RELOCATION</p>

          <h1>
            MOVE WITHOUT<br />
            <span>COMPROMISE.</span>
          </h1>

          <p className="hero-text">
            A smarter way to plan, compare and experience your next move.
          </p>

          <button className="hero-button">
            Plan Your Move →
          </button>
        </div>

        <div className="hero-3d">
          <MovingScene />
        </div>
      </section>

      <Stats />
      <HowItWorks />
      <ProviderShowcase />
    </main>
  );
}

export default Home;
