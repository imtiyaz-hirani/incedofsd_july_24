import { useEffect, useState } from 'react';
import '../css/customer.css'

function Customer(){

    const [name,setName] = useState('');
    const [contact,setContact] = useState('');
    const [nameErr,setNameErr] = useState(null);
    const [contactErr,setContactErr] = useState(null);
    const [showAddBtn,setShowAddBtn] = useState(false);

    useEffect(()=>{
        if(name === '' && contact === '')
            setShowAddBtn(false)
        else 
            setShowAddBtn(true)
    },[nameErr,contactErr,name,contact]);

    const handleInput = (e,field)=>{

        switch(field){
            case 'name':
                 
                setName(e.target.value)
                if(name === ''){
                    setNameErr('Name is Mandatory')
                }
                else{
                    setNameErr('')
                }
                break; 
            case 'contact':
                let contactVal = e.target.value;
                setContact(contactVal)
                if(contact === ''){
                    setContactErr('Contact is Mandatory')
                }
                else{
                    setContactErr('')
                }
                break; 
            default:

        }
         

    }
   

    const addEmployee=()=>{

    }
    return (
      <div className="customer-container">
        <div className="customer-form">
          <div className='form-content'>
            <h1>Add Customer</h1>
            <label>Enter Name: </label>
            <input type="text" onChange={(e)=>handleInput(e,'name') }/> 
            &nbsp;&nbsp; 
            <span className='error-msg'> {nameErr} </span>
            <br /><br />
            <label>Enter Contact: </label>
            <input type="number" onChange={(e)=>handleInput(e,'contact')}/>
            &nbsp;&nbsp; 
            <span className='error-msg'> {contactErr}</span>
            <br /><br />
            {
                showAddBtn === true? <span>
                    <button onClick={()=>addEmployee()}>Add Employee</button>
                </span> : <span>
                    <button  disabled>Add Employee</button>
                </span>
            }
          </div>
        </div>
      </div>
    );
}

export default Customer;