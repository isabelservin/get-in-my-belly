import React, {useEffect, useState} from "react"
import _ from "lodash"

import Error from "./Error"
import {Redirect} from "react-router-dom";

const ReviewForm = props => {
  let restaurantId, restaurantType
  if (props.retaurantId !== null) {
    restaurantId = props.retaurantId
  } else {
    restaurantId = props.match.params.restaurantId
  }

  const [redirect, setRedirect] = useState(null)

  const [newReview, setNewReview] = useState({
    name: "",
    restaurantRating: "",
    review: "",
    address: "",
    phoneNumber: "",
    restaurantId: restaurantId
  })
  const [errors, setErrors] = useState([])

  const [currentRestaurant, setCurrentRestaurant] = useState({
    name: "",
    address: "",
    phoneNumber: ""
  })

  const fetchCurrentAddress = async () => {
    try {
      const response = await fetch(`/api/v1/restaurants/${restaurantId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const body = await response.json()
      setCurrentRestaurant(body)
    } catch (err) {
      console.log(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchCurrentAddress()
  }, [])

  const addNewReview = async (newReview) => {
    let formPayload = newReview
    formPayload.restaurantId = props.id
    try {
      const response = await fetch("/api/v1/reviews", {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(formPayload)
      })
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      } else {
        const body = await response.json()
        if (body) {
          setRedirect(true)
        }
      }
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
    }
  }

  const isFormComplete = () => {
    let submitErrors = {}
    const requiredFields = ["name", "restaurantRating", "review"]
    requiredFields.forEach(field => {
      if (newReview[field].trim() === "") {
        submitErrors = {...submitErrors, [field]: "is required."}
      }
    })
    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const handleChange = event => {
    setNewReview({
      ...newReview,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  const handleSubmit = event => {
    event.preventDefault()
    newReview.name = currentRestaurant.name
    newReview.address = currentRestaurant.address
    newReview.phoneNumber = currentRestaurant.phoneNumber
    // newReview.restaurantId = restaurantId
    const restaurantObj = {...newReview, restaurant: {id: restaurantId}}
    if (isFormComplete()) {
      addNewReview(restaurantObj)
    }
  }

  if (redirect) {
    window.location.reload(true);
    console.log(currentRestaurant.category.type + restaurantId)
    return <Redirect to={`/${currentRestaurant.category.type}/restaurant/${restaurantId}`}/>
  }

  return (
    <>

    <div id="review-form" className="font-caps for-show-page">
        <div className="review-form-container">
        </div>
        <div className="review-form-right-side">
            <h2>Tell us about your experience...</h2>
            <Error errors={errors} />


            <form onSubmit={handleSubmit} >
                <div className="user-box hidden" >
                    <label htmlFor="name"> Restaurant Name
                     <input id="name"
                     type="text"
                     name="name"
                     onChange={handleChange}
                     value={currentRestaurant.name} />
                    </label>
                </div>

                <div className="user-box hidden">
                     <label htmlFor="address">
                        Restaurant Address
                        <input id="address"
                        type="text" name="address"
                        onChange={handleChange}
                        value={currentRestaurant.address} />
                     </label>
                 </div>

                <div className="user-box hidden">
                     <label htmlFor="phoneNumber">
                        Restaurant phone number
                        <input id="phoneNumber"
                        type="text"
                        name="phoneNumber"
                        onChange={handleChange}
                        value={currentRestaurant.phoneNumber} />
                     </label>
                </div>

                <div className="user-box">
                      <label htmlFor="restaurantRating">
                        Rating
                        <input
                          id="restaurantRating"
                          type="text"
                          name="restaurantRating"
                          onChange={handleChange}
                          value={newReview.restaurantRating}
                        />
                      </label>
                </div>

                <div className="user-box">
                    <label htmlFor="review">
                        Your Review
                        <input
                          id="review"
                          type="text"
                          name="review"
                          onChange={handleChange}
                          value={newReview.review}
                        />
                      </label>
                </div>

              <div className="input-box w50">
                <input className="button round" type="submit" value="Submit Review" />
              </div>
            </form>
        </div>
    </div>
    </>
  )
}

export default ReviewForm