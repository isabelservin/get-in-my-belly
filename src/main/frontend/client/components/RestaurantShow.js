import React, { useState, useEffect } from "react"
import RestaurantList from "./RestaurantList.js"


const RestaurantShow = props => {
  const [restaurant, setRestaurant] = useState([])
  const [showForm, setShowForm] = useState(false)
  const [afterSubmission, setAfterSubmission] = useState(false)

  const getRestaurant = async () => {
    try {
      const restaurantId = props.match.params.id
      const restaurantType = props.match.params.type
      const response = await fetch(`/api/v1/restaurants/${restaurantType}/${restaurantId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setRestaurant(responseBody)
    } catch (err) {
      console.error(`Error in Fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    getRestaurant()
  }, [])


  const showReviewForm = event => {
    event.preventDefault()
    setShowForm(true)
  }

  const handleWhatToShow = () => {
    setAfterSubmission(true)
  }

  let formDisplay = ""
  if (showForm) {
    formDisplay = <ReviewForm id={props.match.params.id} handleWhatToShow={handleWhatToShow} />
  }

  let whatToShow
  if (afterSubmission) {
    whatToShow = <SuccessTile />
  } else {
    whatToShow = (
      <div>
        <button onClick={showReviewForm} className="button round">
          Please review!
        </button>
        {formDisplay}
      </div>
    )
  }

  return (
    <div>
      <div className="restaurant-show">

        <img className="images thumbnail" src={restaurant.imgUrl}></img>
        <h1>{restaurant.name}</h1>
        <ul className="no-bullet">
          <li><strong>Review:</strong> {restaurant.review} </li>
        </ul>
      </div>
      {whatToShow}
      <br/>
      <br/>
      <br/>
    </div>
  )
}

export default RestaurantShow
