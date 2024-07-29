 import Navbar from "./components/navbar";
import { useDispatch } from "react-redux";
import { getLeaves } from "../../store/action/leave";

function Employee(){
    const dispatch = useDispatch();
    dispatch(getLeaves())
     
    return (
        <div>
            <Navbar />
        </div>
    )
}

export default Employee;