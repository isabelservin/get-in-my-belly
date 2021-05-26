import React, { useState, useEffect} from "react";
import RestaurantTile from "./RestaurantTile.js"
import ReviewTile from "./ReviewTile.js"

const RestaurantShow = props => {
  const [restaurant, setRestaurant] = useState([]);
  const [location, setLocation] = useState([]);
  const [category, setCategory] = useState([])
  const [restaurantReviews, setRestaurantReviews] = useState ([])

  const getRestaurant = async () => {
    try {
      const restaurantId = props.match.params.id
      const restaurantCategory = props.match.params.categoryName

      const response = await fetch(`/api/v1/restaurants/${restaurantCategory}/${restaurantId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setRestaurant(responseBody)
      setLocation(responseBody.locations[0])
      setCategory(responseBody.category)
      setRestaurantReviews(responseBody.locations[0].reviews)
    } catch (err) {
      console.log(`Error fetching restaurant: ${err.message}`)
    }
  }

  useEffect(() => {
    getRestaurant()
  }, [])
  
  const reviewList = restaurantReviews.map(review => {
    return (
      <ReviewTile
        key={review.id}
        id={review.id}
        review={review.review}
        datePosted = {review.datePosted}
        rating = {review.restaurantRating}
      />
    )
  })

  return (
  <div className="wrap-width">
    <div className="grid-x grid-margin-x">
      <div className="cell small-8">{reviewList}</div>

      <div className="cell small-4">
        <div className = "restaurant-tile-show">
          <RestaurantTile
          location={location}
          key={restaurant.id}
          id={restaurant.id}
          name={restaurant.name}
          imgUrl={restaurant.imageUrl}
          category={category}
          />
        </div>
      </div>
    </div>
  </div>
  )
}

export default RestaurantShow