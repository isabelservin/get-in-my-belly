import React, { useState, useEffect}  from "react";
import { Link } from "react-router-dom"


const CategoryTile = (props) => {
    return(
        <div className="category-box">
            <h3>
                <Link to={`${props.type}/restaurants`}>{props.type}</Link>
            </h3>
            <p>{props.desc} </p>
        </div>

    )

}

export default CategoryTile