import React from "react"
import { Link } from "react-router-dom"

const RestaurantTile = props => {
  console.log(props.imgUrl)
  return (
    <div className="cell">
      <div className="card">
        <div className="card-divider">
          <h2><Link to={`/${props.type}/restaurant/${props.id}`}>{props.name}</Link></h2>
        </div>
        <Link to={`${props.type}/restaurant/${props.id}`}>
          <img className="images thumbnail" src={props.imgUrl} />
        </Link>
        <div className="card-section">
          <p>
            <strong>Review:</strong> {props.review} <br/>
            <button className="review-button" href="/review/new" ><Link to="/review/new">Write a Review</Link></button>
          </p>
        </div>
      </div>
    </div>
  )
}
export default RestaurantTile