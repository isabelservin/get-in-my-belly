import React, {useEffect} from "react"


const RatingStars = props => {
  let starArray = []

  for (let i = 1; i <= 5 ; i++) {
    if ( i <= props.rating ) {
      starArray.push(true)
    } else {
      starArray.push(false)
    }
  }

  const stars = starArray.map((star, index) => {
    if ( star == true ) {
    return <i key={index}
    className="fas fa-star"></i>
    } else {
    return <i  key={index}
    className="far fa-star"></i>
    }
  })

  return <span className="rating-stars">
    {stars}
  </span>

}

export default RatingStars
