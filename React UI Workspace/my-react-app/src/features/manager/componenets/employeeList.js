import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getEmployees } from "../../../store/action/employee";

function EmployeeList(){

    const {list} = useSelector((state)=>state.employee)
    const dispatch = useDispatch();

    useEffect(()=>{
        dispatch(getEmployees())
    },[dispatch]);

    return (
        <div>
            {
                list.map((e,index)=>(
                    <div>
                        <p>{e.name} --- {e.city}</p>
                    </div>
                ))
            }
        </div>
    )
}

export default EmployeeList;