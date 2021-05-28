import _ from "lodash"
import React, {useState} from "react"
import {Redirect} from "react-router-dom"

import Error from "./Error"

const RestaurantForm = props => {
  const [newRestaurant, setNewRestaurant] = useState({
    name: "",
    imageUrl: "",
    category: "",
    description: "",
    phoneNumber: "",
    address: "",
    healthDeptRating: ""
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
    return <Redirect to={`/${newRestaurant.category}/restaurants`}/>
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
      "imageUrl",
      "description",
      "phoneNumber",
      "address"
    ]
    requiredFields.forEach(field => {
      if (newRestaurant[field].trim() === "") {
        submissionErrors = {...submissionErrors, [field]: `is required`}
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
      <>
      <div id="review-form">
        <div className="review-form-container">
          <div>
          </div>
        </div>
        <div className="review-form-right-side">
          <h2>Add a new Restaurant...</h2>
          <Error errors={errors}/>

          <form onSubmit={handleSubmit} id="review-form-box">

            <div className="input-box w50">
              <label htmlFor="name">
                Restaurant Name:
                <input id="name"
                       type="text"
                       name="name"
                       onChange={handleChange}
                       value={newRestaurant.name}/>
              </label>
            </div>

            <div className="input-box w50">
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

            <div className="input-box w50">
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

            <div className="input-box w50">
              <label htmlFor="phoneNumber">
                Restaurant Phone number:
                <input id="phoneNumber"
                       type="text"
                       name="phoneNumber"
                       onChange={handleChange}
                       value={newRestaurant.phoneNumber}/>
              </label>
            </div>

            <div className="input-box w50">
              <label htmlFor="address">
                Restaurant Address:
                <input id="address"
                       type="text"
                       name="address"
                       onChange={handleChange}
                       value={newRestaurant.address}/>
              </label>
            </div>

            <div className="input-box w50">
              <label htmlFor="description">
                Add description:
                <input
                    id="description"
                    type="text"
                    name="description"
                    onChange={handleChange}
                    value={newRestaurant.description}
                />
              </label>
            </div>

            <div className="input-box w50">
              <label htmlFor="healthDeptRating">
                (Optional)Health Department Rating:
                <select
                    id="healthDeptRating"
                    name="healthDeptRating"
                    onChange={handleChange}
                    value={newRestaurant.healthDeptRating}
                >
                  <option value="">Please Select Rating:</option>
                  <option value="0">N/A</option>
                  <option value="1">Need to Improve</option>
                  <option value="2">OK</option>
                  <option value="3">Good</option>
                  <option value="4">Excellent</option>
                </select>
              </label>
            </div>

            <input className="button round" type="submit" value="Submit"/>
      </form>

</div>
</div>
</>
)
}
export default RestaurantForm
