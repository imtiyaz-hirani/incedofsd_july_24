import { Route, Routes } from "react-router";
import Login from "./auth/login";
import HR from "./features/hr/hr";
import EmployeeOnBoarding from "./features/hr/components/employeeonboarding";
import Manager from "./features/manager/manager";
import { Provider, useDispatch } from "react-redux";
import store from "./store";
import { getEmployees } from "./store/action/employee";
import Employee from "./features/employee/employee";
import LeaveDetails from "./features/employee/components/leaveList";
import LeaveDetailsManager from "./features/manager/componenets/leaveDetails";
 
function App() {
  
   return(
    <div>
      <Provider store={store}>
      <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/hr" element={<HR />}></Route>
          <Route path="/employee" element={<Employee />}></Route>
          <Route path="/employee-onboarding" element={<EmployeeOnBoarding />}></Route>
          <Route path="/manager" element={<Manager />}></Route>
          <Route path="/employee-leave-details" element={<LeaveDetails />}></Route>
          <Route path="/manager-leave-details" element={<LeaveDetailsManager />}></Route>

          
      </Routes>
      </Provider>
    </div>
   )
}

export default App;
