import _ from "lodash"
import React, { useState } from "react"
import { Redirect } from "react-router-dom"

import Error from "./Error"

const RestaurantForm = props => {
  const [newRestaurant, setNewRestaurant] = useState({
    name: "",
    restaurantType: "",
    imageUrl: ""
  })
  const [errors, setErrors] = useState([])
  const [redirect, setRedirect] = useState(false)

  const addNewRestaurant = async () => {
    try {
      const response = await fetch("/api/v1/restaurant", {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(newRestaurant)
      })
      if (!response.ok) {
        if (response.status === 422) {
          const data = await response.json()
          return setErrors(data.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw error
        }
      } else {
        const data = await response.json()
        if (data) {
          setRedirect(true)
        }
      }
    } catch (error) {
      console.error(`Error in fetch: ${error}`)
    }
  }

  const handleInput = event => {
    setNewRestaurant({
      ...newRestaurant,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }
  const validateInput = () => {
    let submissionErrors = {}
    const requiredFields = [
      "name",
      "restaurantCategory",
      "imageUrl"
    ]
    requiredFields.forEach(field => {
      if (newRestaurant[field].trim() === "") {
        submissionErrors = { ...submissionErrors, [field]: `is required` }
      }
    })
    setErrors(submissionErrors)
    return _.isEmpty(submissionErrors)
  }

  const handleSubmit = event => {
    event.preventDefault()
    if (validateInput()) {
      addNewRestaurant()
    }
  }

  if (redirect) {
    return <Redirect to="/restaurant" />
  }

  return (
    <div>
      <h2>Add a Restaurant:</h2>
      <form onSubmit={handleSubmit} className="restaurant_app">
        <div className="grid-container">
          <div>
            <div>
              <Error errors={errors} />
            </div>

            <div className="row">
              <div className="medium-6 columns">
                <label htmlFor="name">
                  Restaurant Name:
                  <input
                    id="name"
                    type="text"
                    name="name"
                    onChange={handleInput}
                    value={newRestaurant.name}
                  />
                </label>
              </div>
            </div>

            <div className="row">
              <div className="medium-6 columns">
                <label htmlFor="restaurantCategory">
                  Restaurant Category:
                  <select
                    id="restaurantCategory"
                    name="restaurantCategory"
                    value={newRestaurant.restaurantType}
                    onChange={handleInput}
                  >
                    <option value="">Please Select A Category</option>
                    <option value="Vietnamese">Vietnamese</option>
                    <option value="Pacific Island">Pacific Island</option>
                    <option value="Mexican">Mexican</option>
                  </select>
                </label>
              </div>
            </div>

            <div className="row">
              <div className="medium-6 columns">
                <label htmlFor="imageUrl">
                  Add picture of noteworthy meal:
                  <input
                    id="imageUrl"
                    type="text"
                    name="imageUrl"
                    onChange={handleInput}
                    value={newRestaurant.imageUrl}
                  />
                </label>
              </div>
            </div>

            <input className="button round" type="submit" value="Submit" />
          </div>
        </div>
      </form>
    </div>
  )
}
export default RestaurantForm
