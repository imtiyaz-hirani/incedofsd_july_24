import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getEmployees } from "../../../store/action/employee";
 
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { IconField } from 'primereact/iconfield';
import { InputIcon } from 'primereact/inputicon';
 import { InputText } from 'primereact/inputtext'; 
import { FilterMatchMode } from "primereact/api";
 
function EmployeeList(){

    const {list} = useSelector((state)=>state.employee)
    const dispatch = useDispatch();
    const [filters,] = useState({
        name: { value: null, matchMode: FilterMatchMode.CUSTOM },
        city: { value: null, matchMode: FilterMatchMode.EQUALS },
        salary: { value: null, matchMode: FilterMatchMode.EQUALS }
    });
    const [loading,setLoading] = useState(true);

    useEffect(()=>{
        dispatch(getEmployees())
        setLoading(false)
        
    },[dispatch]);

    const globalSearch = (val)=>{
        console.log(val)
    }
    const renderHeader = () => {
        return (
            <div className="flex justify-content-end">
                <IconField iconPosition="left">
                    <InputIcon className="pi pi-search" />
                    <InputText   onChange={(e)=>globalSearch(e.target.value)} placeholder="Keyword Search" />
                </IconField>
            </div>
        );
    };

    const showTask = (id)=>{
        console.log(id)
    }

    const header = renderHeader();

    const actionBodyTemplate = (rowData) => {
        return (
            <div className="flex align-items-center gap-2">
                <button className="btn btn-info" onClick={()=>showTask(rowData.id)}> Show Tasks</button>
            </div>
        );
    };

    const cityRowFilter=(value)=>{
        console.log(value)
    }
     

    return (
        <div className="card" >
        <DataTable value={list} paginator rows={5} dataKey="id" filters={filters} filterDisplay="row" loading={loading}
                header={header} emptyMessage="No customers found.">
            <Column field="name" header="Name" filter filterPlaceholder="Search by name" style={{ minWidth: '8rem' }} />
            <Column field="city" header="City" filterField="city" style={{ minWidth: '8rem' }}   filter filterPlaceholder="Search by City"  filterElement={cityRowFilter}/>
            <Column field="salary" header="Salary" filterField="salary" style={{ minWidth: '8rem' }}  />
            <Column  field="jobTitle" header="Job Title" filterField="jobTitle" style={{ minWidth: '12rem' }}  filter filterPlaceholder="Search by job Title" />
            <Column header="Action"  body={actionBodyTemplate}> </Column>
          </DataTable>
    </div>
    )
}

export default EmployeeList;