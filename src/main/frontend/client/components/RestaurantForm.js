import _ from "lodash"
import React, { useState } from "react"
import { Redirect } from "react-router-dom"

import Error from "./Error"

const RestaurantForm = props => {
  const [newRestaurant, setNewRestaurant] = useState({
    name: "",
    imageUrl: "",
    category: ""
  })

  const [errors, setErrors] = useState([])
  const [redirect, setRedirect] = useState(false)

  const addNewRestaurant = async () => {
    console.log(newRestaurant)
    try {
      const response = await fetch("/api/v1/restaurants", {
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


  if (redirect) {
    console.log(newRestaurant.category)
    return <Redirect to = {`/${newRestaurant.category}/restaurants`} />
  }

  const handleChange = event => {
    setNewRestaurant({
      ...newRestaurant,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  const validateInput = () => {
    let submissionErrors = {}
    const requiredFields = [
      "name",
      "category",
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

  return (
    <form onSubmit={handleSubmit} className="restaurant_app">
      <div className="grid-container">
        <div className="grid-x grid-padding-x">
          <div className="cell">
            <h2>Add New Restaurant:</h2>
            <Error errors={errors} />
          </div>

          <div className="row">
            <div className="medium-6 columns">
              <label htmlFor="name">
                Restaurant Name:
                <input id="name"
                type="text"
                name="name"
                onChange={handleChange}
                value={newRestaurant.name} />
              </label>
            </div>

            <div className="medium-6 columns">
              <label htmlFor="category">
                Restaurant Category:
                <select
                  id="category"
                  name="category"
                  onChange={handleChange}
                    value={newRestaurant.category}
                  >
                  <option value="">Please Select Category</option>
                  <option value="Vietnamese">Vietnamese</option>
                  <option value="Pacific Island">Pacific Island</option>
                  <option value="Mexican">Mexican</option>
                  </select>
              </label>
            </div>

          <div className="row">
            <div className="medium-6 columns">
              <label htmlFor="imageUrl">
                Add food image URL:
                <input
                  id="imageUrl"
                  type="text"
                  name="imageUrl"
                  onChange={handleChange}
                  value={newRestaurant.imageUrl}
                />
              </label>
            </div>
          </div>

          <input className="button round" type="submit" value="Submit" />
        </div>
        </div>
      </div>
    </form>

  )
}
export default RestaurantForm
