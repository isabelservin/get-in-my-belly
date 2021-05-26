import React from "react"

const RestaurantTile = props => {

  let phoneNumberFormatted = ""
  if (props.location.phoneNumber != undefined && props.location.phoneNumber.length == 10) {
    phoneNumberFormatted = props.location.phoneNumber.replace(/(\d{3})(\d{3})(\d{4})/, "($1) $2-$3")
  }

  return (
    <>
      <h2>{props.name}</h2>
      <span>{props.category.type}</span>
      <ul className="address-phone-ul">
      <li>{props.location.address}</li>
      <li>{phoneNumberFormatted}</li>
      </ul>
      <img src={props.imgUrl} />
    </>
  )
}

export default RestaurantTile