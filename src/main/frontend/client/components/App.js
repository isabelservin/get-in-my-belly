import React from "react"
import { hot } from "react-hot-loader/root"
import { Route, Switch, BrowserRouter, Redirect } from "react-router-dom"
import "regenerator-runtime/runtime"
import RestaurantList from "./RestaurantList";

const App = props => {
  return (
      <BrowserRouter>

        <div>
          <div>
            <Switch>
              <Route exact path="/restaurants" component={RestaurantList} />
              <Route exact path="/restaurants/new" component={RestaurantForm} />
              <Route exact path="/review/new" component={ReviewForm} />
            </Switch>
          </div>
        </div>
      </BrowserRouter>
  )
}
export default hot(App)
