import React, { useState, useEffect}  from "react"
import CategoryTile from './CategoryTile'

const CategoryList = (props) => {
    const [categories, setCategories] = useState([])

    const getCategories = async () => {
        try {
          //const type = props.match.params.type
          const response = await fetch(`/api/v1/categories`)
          if (!response.ok) {
            const errorMessage = `${response.status} (${response.statusText})`
            const error = new Error(errorMessage)
            throw error
          }
          const responseBody = await response.json()
          setCategories(responseBody)
        } catch (error) {
          console.log(`Error in fetch: ${err.message}`)
        }
      }

    useEffect(() => {
        getCategories()
    }, [])

    const listOfCategories = categories.map(category => {
        return(
            <CategoryTile
               key={category.id}
               id={category.id}
               type={category.type}
               desc={category.description}
            />
        )
    })

    return(
        <>
        <div className="content">
          <div className="category">
            {listOfCategories}
          </div>
        </div>
        </>
    )
}

export default CategoryList