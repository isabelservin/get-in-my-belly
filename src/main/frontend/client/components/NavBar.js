import React from "react"
import { Link } from "react-router-dom"

const NavBar = () => {

  return (
    <div className="nav">
      <div>
        <ul className="menu" id="navbar">
          <li>
            <Link to="/categories">Home</Link>
          </li>
          <li>
            <Link to="/restaurant/new">Add a Restaurant</Link>
          </li>
          <li>
            <Link to="/review/new">Write A Review</Link>
          </li>
        </ul>
      </div>
    </div>
  )
}

export default NavBar
