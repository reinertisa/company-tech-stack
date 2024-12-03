import {Link} from "react-router";

export default function Navbar() {

    return (
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
            <div className="container-xxl">
                <a className="navbar-brand" href="#">
                    <span className="fw-bold text-secondary">
                        CTS
                    </span>
                </a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <Link to="/companies" className="nav-link">Companies</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/techStacks" className="nav-link">Tech Stacks</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}



