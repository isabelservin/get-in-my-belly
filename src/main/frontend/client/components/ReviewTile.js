import React, {useState} from "react"
import {Link} from "react-router-dom"
import ReviewStars from "./ReviewStars.js"
import ReviewForm from "./ReviewForm";

const ReviewTile = props => {
  let date = new Date(props.datePosted).toDateString()

  const [showForm, setShowForm] = useState(false)
  const showReviewForm = event => {
    event.preventDefault()
    setShowForm(true)
  }

  let formDisplay = ""
  if (showForm) {
    console.log(props.restaurantId)
    formDisplay = <ReviewForm retaurantId={props.restaurantId}/>
  }

  return (
      <>
        <div className="review-tile">
          <div className="review-form">
            <div className="write-review-button" onClick={showReviewForm}>
              {/*<Link to={`/${props.id}/review/new`}>Write a Review</Link>*/}
              Write a Review
            </div>
          </div>
        <div className="stars-and-review-date">
            <span className="review-stars">
              <ReviewStars
                rating={props.rating}
            />
          </span>
            <span className="review-date">{date}</span>
          </div>
          <div className="review-body">
            {props.review}
          </div>
        </div>
        <div>
          {formDisplay}
        </div>
      </>
  )
}
export default ReviewTile