import { useEffect, useState } from "react";
import Navbar from "./navbar";
 import { useSelector } from "react-redux";

function LeaveDetails(){
    
    const {list} = useSelector(state=>state.leave);
    const [leaves,setLeaves] = useState([...list]);
    
    return (
        <div>
            <Navbar />
            <div className="container">
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