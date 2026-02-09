import { useContext } from "react";
import { motion } from "framer-motion";
import { MdLogin } from "react-icons/md";
import { useNavigate } from "react-router-dom";
import { DemoContext } from "../context/DemoContext";

export default function DemoLogInPage() {
  const navigate = useNavigate();
  const { setDemo } = useContext(DemoContext);

  const handleEnterDemo = () => {
    setDemo(true);
    navigate("/dashboard");
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-slate-950 via-slate-900 to-black px-4">
      <motion.div
        initial={{ opacity: 0, scale: 0.9 }}
        animate={{ opacity: 1, scale: 1 }}
        transition={{ duration: 0.4 }}
        className="w-full max-w-md bg-white/5 backdrop-blur-xl border border-white/10 rounded-3xl p-8 shadow-2xl text-center"
      >
        <div className="flex justify-center mb-4 text-green-400">
          <MdLogin size={48} />
        </div>

        <h1 className="text-3xl font-bold text-white mb-2">
          Enter Demo Mode
        </h1>

        <p className="text-gray-400 mb-6">
          Click the button below to explore the dashboard with sample data.
        </p>

        <button
          onClick={handleEnterDemo}
          className="px-6 py-3 rounded-xl bg-gradient-to-r from-green-600 to-teal-600 text-white font-semibold hover:opacity-90 transition"
        >
          Enter Demo
        </button>
      </motion.div>
    </div>
  );
}
