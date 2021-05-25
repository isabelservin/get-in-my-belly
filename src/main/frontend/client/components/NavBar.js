import React from "react"
import { Link } from "react-router-dom"

const NavBar = () => {

  return (
    <div className="title-bar">
      <div className="top-bar-left">
        <ul className="menu">
          <li>
            <Link to="/category">Home</Link>
          </li>
          <li>
            <Link to="/restaurant/new">Add a Restaurant</Link>
          </li>
          <li>
            <Link to="/review/new">Add a Review</Link>
          </li>
        </ul>
      </div>
    </div>
  )
}

export default NavBar
