import React, { useState, useEffect} from "react";
import RestaurantTile from "./RestaurantTile.js"
import ReviewTile from "./ReviewTile.js"
import {Redirect} from "react-router-dom";

const RestaurantShow = props => {
  const [restaurant, setRestaurant] = useState([]);
  const [category, setCategory] = useState([])
  const [restaurantReviews, setRestaurantReviews] = useState ([])
  const [notFound, setNotFound] = useState(null)

  const getRestaurant = async () => {
    try {
      const restaurantId = props.match.params.id
      const restaurantCategory = props.match.params.categoryName
      const response = await fetch(`/api/v1/${restaurantCategory}/restaurant/${restaurantId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        setNotFound("not found")
        throw error
      }
      const responseBody = await response.json()
      setRestaurant(responseBody)
      setCategory(responseBody.category)
      setRestaurantReviews(responseBody.reviews)
    } catch (err) {
      console.log(`Error fetching restaurant: ${err.message}`)
    }
  }

  useEffect(() => {
    getRestaurant()
  }, [])

  if (notFound) {
    return <Redirect to={"/404"} />
  }

  const reviewList = restaurantReviews.map(review => {
    return (
      <ReviewTile
        key={review.id}
        id={review.id}
        review={review.review}
        datePosted = {review.datePosted}
        rating = {review.restaurantRating}
        restaurantId={props.match.params.id}
        type={props.match.params.categoryName}
      />
    )
  })


  return (
  <div className="content">
    <div className="grid-x grid-margin-x">
      <div className="cell small-8">
        {reviewList}
      </div>

      <div className="cell small-4">
        <div className = "restaurant-tile-show">
          <RestaurantTile
          address={restaurant.address}
          phoneNumber={restaurant.phoneNumber}
          healthDeptRating={restaurant.healthDeptRating}
          description={restaurant.description}
          key={restaurant.id}
          id={restaurant.id}
          name={restaurant.name}
          imgUrl={restaurant.imageUrl}
          category={category}
          restaurant={restaurant}
          />
        </div>
      </div>
    </div>
  </div>
  )
}

export default RestaurantShow
