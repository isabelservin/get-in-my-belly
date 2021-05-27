import React from "react"
import { Link } from "react-router-dom"

const RestaurantTile = props => {

  return (
    <div>
      <h2>{props.name}</h2>
      <ul className="address-phone-ul">
        <li>{props.category.type}</li>
        <li>{props.phoneNumber}</li>
        <li>{props.address}</li>
      </ul>

      <img src={props.imgUrl} />
      <p>{props.description}</p>
    </div>
  )
}

export default RestaurantTile