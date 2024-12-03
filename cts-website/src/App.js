import './App.css';
import Navbar from "./components/root/Navbar";
import {BrowserRouter, Route, Routes} from "react-router";
import CompanyPage from "./components/edit/Company";
import TechStackPage from "./components/edit/TechStack";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Navbar />
                <Routes>
                    <Route path="/companies" element={<CompanyPage />} />
                    <Route path="/techStacks" element={<TechStackPage />} />
                </Routes>
            </BrowserRouter>
        </div>
  );
}

export default App;
