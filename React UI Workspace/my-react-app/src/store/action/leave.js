import axios from "axios"

export const getLeaves=()=>(dispatch)=>{
    //call the api 
    axios.get('http://localhost:8081/api/leave/all',{
        headers: {
            'Authorization': 'Basic ' + localStorage.getItem('token')
        }
    })
    
    .then(response=>{
        let action = {
            type: 'GET_ALL_LEAVES',
            payload: response.data
        };

        dispatch(action)
    })
}