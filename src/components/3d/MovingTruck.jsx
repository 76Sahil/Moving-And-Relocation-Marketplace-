import { Float, Box } from "@react-three/drei";

export default function MovingTruck() {
  return (
    <Float speed={1.5} rotationIntensity={0.15} floatIntensity={0.25}>
      <group>
        <Box args={[2.8, 1.2, 1.3]} position={[0, 0.9, 0]}>
          <meshStandardMaterial color="#c9a96e" />
        </Box>

        <Box args={[1.1, 1, 1.25]} position={[1.85, 0.8, 0]}>
          <meshStandardMaterial color="#24221e" />
        </Box>

        {[-1, 1].map((x) =>
          [-0.7, 0.7].map((z) => (
            <mesh
              key={`${x}-${z}`}
              position={[x * 1.25, 0.35, z * 0.65]}
              rotation={[Math.PI / 2, 0, 0]}
            >
              <cylinderGeometry args={[0.35, 0.35, 0.25, 32]} />
              <meshStandardMaterial color="#11100e" />
            </mesh>
          ))
        )}
      </group>
    </Float>
  );
}
