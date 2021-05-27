import React from "react"
import { Link } from "react-router-dom"

const NavBar = () => {

//        <div className="site-name">
  return (
    <div>
      <div className="banner">
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
        <h1 className="site-name"> Get In My Belly! </h1>
    </div>
          </div>
  )
}

export default NavBar
