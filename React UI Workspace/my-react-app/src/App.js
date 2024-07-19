import { useState } from 'react';
import './App.css';
import './style.css';
function App() {
   
  let [arry,setArry] = useState([5,3,1,7,2,3,9]);
  let [arryClone,] = useState([...arry]);

  const sortArry=(op)=>{
    let temp =[...arry]; 
    if(op === 'ASC'){
      temp.sort((a, b) => a - b);
      setArry([...temp])
      return; 
    }
    if(op === 'DESC'){
      temp.sort((a, b) => b - a);
      setArry([...temp])
      return;
    }
    setArry([...arryClone])
    return; 
  }
  return (
    <div className="App">
      <div className='message'>
        Hello React!!!
      </div>
      <hr />
       {
        arry.map((e,index)=>(
          <div key={index}> 
              {e}
          </div>
        ))
       }

       <div>
        <button onClick={()=>sortArry('ASC')}>Sort-ASC</button>
        <button onClick={()=>sortArry('RESET')}>RESET</button>
        <button onClick={()=>sortArry('DESC')}> Sort-DESC</button>
       </div>
    </div>
  );     
}

export default App;
