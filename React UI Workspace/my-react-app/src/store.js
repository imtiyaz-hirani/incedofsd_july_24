import { configureStore }  from "@reduxjs/toolkit";
import employee from "./store/reducer/employee";
import leave from "./store/reducer/leave";

export default configureStore(
    {
         reducer: {employee,leave}, //<--all reducers entry goes here
    }
)