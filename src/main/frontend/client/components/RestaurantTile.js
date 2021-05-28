import React from "react"
import { Link } from "react-router-dom"
import ReviewTile from "./ReviewTile";

const RestaurantTile = props => {

  let phoneFormat = ""
  if (props.phoneNumber != undefined) {
    phoneFormat = ["(", props.phoneNumber.slice(0,3), ") ", props.phoneNumber.slice(3, 6), "-", props.phoneNumber.slice(6)].join("")
    console.log(phoneFormat)
    
  }

  return (
    <div>
      <h2>{props.name}</h2>
      <ul className="address-phone-ul">
        <li>{props.category.type}</li>
        <li>{phoneFormat}</li>
        <li>{props.address}</li>
      </ul>
      <img src={props.imgUrl} />
      <p>{props.description}</p>
    </div>
  )
}

export default RestaurantTile