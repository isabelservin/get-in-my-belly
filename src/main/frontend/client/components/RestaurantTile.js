import React from "react"
import { Link } from "react-router-dom"
import ReviewTile from "./ReviewTile";

const RestaurantTile = props => {
  console.log(props)
  const showListOfReview = props.restaurant.reviews.map( review => {
    return (
        <ReviewTile
          key={review.id}
          id={review.id}
          datePosted={review.datePosted}
          review={review.review}
          rating={review.restaurantRating}
        />
    )
  })


  return (
    <div className="cell">
      <div className="card">
        <div className="card-divider">
          <h2><Link to={`/${props.type}/restaurant/${props.id}`}>{props.name}</Link></h2>
        </div>
        <Link to={`/${props.type}/restaurant/${props.id}`}>
          <img className="images thumbnail" src={props.imgUrl} />
        </Link>
        <div className="card-section">
          <p>
            <strong>Review:</strong><br/>
            {showListOfReview}
            {/*<button className="review-button" href="/review/new" ><Link to="/review/new">Write a Review</Link></button>*/}
            <button className="review-button" href="/review/new" ><Link to={`/${props.id}/review/new`}>Write a Review</Link></button>
          </p>
        </div>
      </div>
    </div>
  )
}
export default RestaurantTile