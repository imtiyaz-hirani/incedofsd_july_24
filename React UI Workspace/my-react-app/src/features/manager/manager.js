import { useEffect } from "react";
import { getEmployees } from "../../store/action/employee";
import { useDispatch } from "react-redux";

function Manager(){
    const dispatch = useDispatch();
    useEffect(()=>{
        dispatch(getEmployees())
    })
    return (
        <div>
            <h1>Manager screen</h1>
        </div>
    )
}

export default Manager; 