import React from "react"
import { hot } from "react-hot-loader/root"
import { Route, Switch, BrowserRouter, Redirect } from "react-router-dom"
import "regenerator-runtime/runtime"
import RestaurantList from "./RestaurantList";

const App = props => {
  return (
      <BrowserRouter>

        <div className="grid-container no-bullet">
          <div className="grid-x grid-margin-x text-center">
            <Switch>
              <Route exact path="/:categoryName/restaurants" component={RestaurantList} />
            </Switch>
          </div>
        </div>
      </BrowserRouter>
  )
}
export default hot(App)
