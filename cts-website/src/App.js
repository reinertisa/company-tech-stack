import './App.css';
import Navbar from "./Components/Root/Navbar";
import {BrowserRouter, Route, Routes} from "react-router";
import CompanyPage from "./Components/Edit/Company";
import TechStackPage from "./Components/Edit/TechStack";

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
