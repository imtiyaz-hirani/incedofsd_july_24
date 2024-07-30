import { useEffect, useState } from "react";
import Navbar from "./navbar";
 import { useDispatch, useSelector } from "react-redux";
import { addLeaves, deleteLeave, getLeaves } from "../../../store/action/leave";
 function LeaveDetails(){
    
    const dispatch = useDispatch();
    const {list} = useSelector((state)=>state.leave);
    const [leaves,setLeaves] = useState([...list]);
    
    useEffect(()=>{
        dispatch(getLeaves())
    },[dispatch]);

    const onDeleteLeave =(id)=>{
        dispatch(deleteLeave(id));

    }

    const onAddLeave = ()=>{
        let leave = {
            "reason":"Have to travel",
            "startDate":"2024-08-14",
            "endDate":"2024-08-15",
            "noOfDays":2
        }
        dispatch(addLeaves(leave));
    }
    return (
        <div>
            <Navbar />
            <div className="container">
                <div>
                    <button onClick={()=>onAddLeave()}>Add Leave</button>
                </div>
                {
                    leaves.map((l,index)=>(
                        <div className="row mt-4" key={index}>
                            <div className="col-lg-12"> 
                                <div className="card">
                                    <div className="card-header">
                                        <span>Start Date: {l.startDate}</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <span>End Date: {l.endDate}</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <span>
                                            Status: {l.status}
                                        </span>
                                    </div>
                                    <div className="card-body">
                                        <span>Number fo Days Requested: {l.noOfDays}</span>
                                        <br />
                                        <p>
                                            {l.reason}
                                        </p>
                                    </div>
                                    <div className="card-footer">
                                        <button className="btn btn-warning">Archive</button>
                                        &nbsp;&nbsp;&nbsp;
                                        <button className="btn btn-warning" onClick={()=>onDeleteLeave(l.id)}>Delete</button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    ))
                }
            </div>
        </div>
    )
}

export default LeaveDetails;