import { useEffect, useState } from 'react';
import '../css/customer.css'

function Customer(){

    const [name,setName] = useState(null);
    const [contact,setContact] = useState(null);
    const [nameErr,setNameErr] = useState(null);
    const [contactErr,setContactErr] = useState(null);
    const [showAddBtn,setShowAddBtn] = useState(false);

    useEffect(()=>{
        if(name === null || contact === null)
            setShowAddBtn(false)
        else
        if((name === ''  || contact === '')) {
            setShowAddBtn(false)
        }
         else {
            setShowAddBtn(true)
            console.log(name +'--' + contact)
        }

        if(name === '')
            setNameErr('Name is mandatory')
        else
            setNameErr('')

        if(contact === '')
            setContactErr('contact is mandatory')
        else
            setContactErr('')
        
       if(contact !== '' && contact?.length !== 10)
            setContactErr('contact shd be 10 digit')
        else
            setContactErr('')
    
        
            
    },[name,contact]);

    const handleName = (e)=>{
        setName(e.target.value)
        
     }
    const handleContact = (e)=>{
        setContact(e.target.value)
        
     }
    const addEmployee=()=>{

    }
    return (
      <div className="customer-container">
        <div className="customer-form">
          <div className='form-content'>
            <h1>Add Customer</h1>
            <label>Enter Name: </label>
            <input type="text" onChange={(e)=>handleName(e) }/> 
            &nbsp;&nbsp; 
            <span className='error-msg'> {nameErr} </span>
            <br /><br />
            <label>Enter Contact: </label>
            <input type="number" onChange={(e)=>handleContact(e)}/>
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