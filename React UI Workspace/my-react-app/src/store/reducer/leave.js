const intialState ={
    list: []
}

const leave = (state=intialState,action)=>{
      if(action.type === 'GET_ALL_LEAVES'){
        let temp = action.payload; 
        return {...state, list: temp}
      }

    return state; 
}

export default leave;