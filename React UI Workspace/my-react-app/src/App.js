import { Route, Routes } from "react-router";
import Login from "./auth/login";
import HR from "./features/hr/hr";
 
function App() {
   return(
    <div>
      <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/hr" element={<HR />}></Route>
      </Routes>
    </div>
   )
}

export default App;
