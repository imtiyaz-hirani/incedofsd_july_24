
import { useEffect } from "react";
import EmployeeList from "./componenets/employeeList";
import { useDispatch } from "react-redux";
import { getEmployees } from "../../store/action/employee";

function Manager(){
    const dispatch = useDispatch();
    dispatch(getEmployees())

    return (
        <div>
            <EmployeeList />
        </div>
    )
}

export default Manager; 