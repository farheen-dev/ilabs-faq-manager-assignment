import React from "react"
import { BrowserRouter as Router , Routes, Route } from "react-router-dom"
import FAQDashboard from "./components/FAQDashboard"
import SignUp from './components/SignUp'
import SingIn from './components/SignIn'

export const ModalContext = React.createContext()

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<SingIn />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/dashboard" element={<FAQDashboard />} />
      </Routes>
    </Router>
  );
};

export default App;
