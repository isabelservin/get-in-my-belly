import React, {useState, useEffect} from "react";
import Error from "./Error";
import _ from "lodash";
import {Redirect} from "react-router-dom";

const ReviewFormForNewRestaurant = props => {
  const [redirect, setRedirect] = useState(null)
  const [errors, setErrors] = useState([])
  const [restaurantsList, setRestaurantList] = useState([])

  const [newReview, setNewReview] = useState({
    restaurantRating: "",
    review: ""
  })

  const fetchAll = async () => {
    try {
      const response = await fetch("/api/v1/restaurants")
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setRestaurantList(responseBody.content)
      console.log(responseBody.content)
    } catch (err) {
      console.log(`Error fetching restaurant: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchAll()
  }, [])

  let [select, setSelect] = useState("️")
  let handleSelect = event => {
    setSelect(event.target.value)
  }

  const addNewReview = async (newReview) => {
    try {
      const response = await fetch("/api/v1/reviews/new", {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(newReview)
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
    // const requiredFields = ["name", "restaurantRating", "review"]
    const requiredFields = ["restaurantRating", "review"]
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

    console.log(select)
    const newReviewPerRes = {...newReview, restaurant: {name: select}}
    console.log(newReviewPerRes)
    if (isFormComplete()) {
      addNewReview(newReviewPerRes)
    }
  }

  if (redirect) {
    return <Redirect to="/categories"/>
  }

  return (
      <>
        <div id="review-form" className="font-caps">
          <div className="review-form-container">
            <div>
            </div>
          </div>
          <div className="review-form-right-side">
            <h2>Add New Review</h2>
            <Error errors={errors}/>

            <form onSubmit={handleSubmit} cid="review-form-box">

              <div className="user-box">
                <label htmlFor="name">
                  Restaurant name
                  <select onChange={handleSelect}>
                    <option value=""> -- Select a Restaurant --</option>
                    {restaurantsList.map((restaurant) => <option
                        value={restaurant.name}>{restaurant.name}</option>)}
                  </select>
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
                  Your review:
                  <input
                      id="review"
                      type="text"
                      name="review"
                      onChange={handleChange}
                      value={newReview.review}
                  />
                </label>
              </div>


              <input className="button round" type="submit"
                     value="Submit Review"/>
            </form>

          </div>
        </div>
      </>
  )
}

export default ReviewFormForNewRestaurant