import React, { useState, useEffect}  from "react";
//import RestaurantTile from "./RestaurantTile.js"

const RestaurantList = props => {
  const [restaurantType, setRestaurantType] = useState([])

  const fetchRestaurantType = async () => {
    try {
      const type = props.match.params.type
      const response = await fetch(`/api/v1/restaurants/${type}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const fetchedData = await response.json()
      setRestaurantType(fetchedData)
    } catch (error) {
      console.error(error)
    }
  }

  useEffect(() => {
    fetchRestaurantType()
  }, [props])

  const RestaurantList = restaurantType.map(restaurant => {
    return (
      <RestaurantTile
        key={restaurant.id}
        id={restaurant.id}
        name={restaurant.name}
        imgUrl={restaurant.imgUrl}
        type={props.match.params.type}
      />
    )
  })
  return <div>{restaurantList}<br/><br/></div>
}

export default RestaurantList