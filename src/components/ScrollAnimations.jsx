import { useLayoutEffect } from "react";
import gsap from "gsap";
import { ScrollTrigger } from "gsap/ScrollTrigger";

gsap.registerPlugin(ScrollTrigger);

export default function ScrollAnimations() {
  useLayoutEffect(() => {
    const ctx = gsap.context(() => {
      gsap.from(".hero-content > *", {
        y: 50,
        opacity: 0,
        duration: 1,
        stagger: 0.15,
        ease: "power3.out"
      });

      gsap.from(".hero-3d", {
        x: 100,
        opacity: 0,
        duration: 1.4,
        ease: "power3.out"
      });

      gsap.from(".stats > div", {
        scrollTrigger: {
          trigger: ".stats",
          start: "top 80%"
        },
        y: 40,
        opacity: 0,
        duration: 0.8,
        stagger: 0.15
      });

      gsap.from(".steps > div", {
        scrollTrigger: {
          trigger: ".steps",
          start: "top 80%"
        },
        y: 60,
        opacity: 0,
        duration: 0.8,
        stagger: 0.2
      });

      gsap.from(".provider-card", {
        scrollTrigger: {
          trigger: ".provider-grid",
          start: "top 80%"
        },
        y: 70,
        opacity: 0,
        duration: 0.8,
        stagger: 0.15
      });
    });

    return () => ctx.revert();
  }, []);

  return null;
}
