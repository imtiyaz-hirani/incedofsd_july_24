import { Route, Routes } from "react-router";
import Login from "./auth/login";
import HR from "./features/hr/hr";
import EmployeeOnBoarding from "./features/hr/components/employeeonboarding";
import Manager from "./features/manager/manager";
 
function App() {
   return(
    <div>
      <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/hr" element={<HR />}></Route>
          <Route path="/employee-onboarding" element={<EmployeeOnBoarding />}></Route>
          <Route path="/manager" element={<Manager />}></Route>
      </Routes>
    </div>
   )
}

export default App;
