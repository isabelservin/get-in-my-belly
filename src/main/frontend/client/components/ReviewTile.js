import React from "react"
import { Link } from "react-router-dom"

const ReviewTile = props => {
let date = new Date(props.datePosted).toDateString()
  return (
      <div className="card-section">
       <p> <strong>Rating:</strong> {props.rating} Out of 5 </p>
       <p> <strong>Date Posted:</strong> {date}  </p>
       <p> <strong>Review:</strong> {props.review}  </p>
      </div>
  )
}
export default ReviewTile