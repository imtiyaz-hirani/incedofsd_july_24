const intialState ={
    list: []
}

const employee = (state=intialState,action)=>{
    console.log(action.payload)

    return state; 
}

export default employee;