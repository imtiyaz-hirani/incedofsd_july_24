import { Route, Routes } from "react-router";
import Login from "./auth/login";
import HR from "./features/hr/hr";
import EmployeeOnBoarding from "./features/hr/components/employeeonboarding";
 
function App() {
   return(
    <div>
      <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/hr" element={<HR />}></Route>
          <Route path="/employee-onboarding" element={<EmployeeOnBoarding />}></Route>
      </Routes>
    </div>
   )
}

export default App;
