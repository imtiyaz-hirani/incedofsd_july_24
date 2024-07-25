import { Route, Routes } from "react-router";
import Login from "./auth/login";
import HR from "./features/hr/hr";
import EmployeeOnBoarding from "./features/hr/components/employeeonboarding";
import Manager from "./features/manager/manager";
import { Provider } from "react-redux";
import store from "./store";
 
function App() {
   return(
    <div>
      <Provider store={store}>
      <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/hr" element={<HR />}></Route>
          <Route path="/employee-onboarding" element={<EmployeeOnBoarding />}></Route>
          <Route path="/manager" element={<Manager />}></Route>
      </Routes>
      </Provider>
    </div>
   )
}

export default App;
