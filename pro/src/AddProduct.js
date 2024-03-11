import React, {useState, useEffect} from 'react'
import {Link, useParams,useNavigate } from 'react-router-dom';
import Service from './Service'
import swal from 'sweetalert2';

const AddProduct = () => {

    const[image,setImage]=useState('');
    const [footwearname, setFootwearname ]= useState('')
    const [brandname, setBrandname] = useState('')
    const [price, setPrice] = useState('')
    const [avail,setAvail]=useState('')
    const {id} = useParams();
    const navigate=useNavigate();
    const showmessage=(message)=>
    {
      swal.fire({
        icon:'error',
        title:'Product cannot be added',
        text:message
  
      });
    }
async function Addition(e){
    e.preventDefault();
       if(price<=0)
        {
            showmessage("Price value should be valid")
            setPrice("")
        }
        else if(avail<0)
        {
            showmessage("Availability value should be valid")
            setAvail("")
        }
    else{    
    Service.createProduct(image,footwearname,brandname,price,avail).then((response)=>{
        console.log(response);
        navigate('/ProductsList')
    }).catch((err)=>{
        console.log(err)
    })}
}


    return (
        <div>
           <br /><br />
           <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                      <h2>ADD PRODUCT</h2>
                        <div className = "card-body">
                            <form encType='multipart/form-data'>
                            <div className = "form-group mb-2">
                                    <label className = "form-label"> Product image :</label>
                                    <input
                                        type = "file"
                                        placeholder = "Upload image"
                                        name = "image"
                                        className = "form-control"
                                        files = {image}
                                        onChange = {(e) => setImage(e.target.files[0])}
                                    >
                                    </input>
                                </div>
                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Footwearname</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter footwear name"
                                        name = "footwearname"
                                        className = "form-control"
                                        value = {footwearname}
                                        onChange = {(e) => setFootwearname(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Brandname :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter brandname"
                                        name = "brandname"
                                        className = "form-control"
                                        value = {brandname}
                                        onChange = {(e) => setBrandname(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Price</label>
                                    <input
                                        type = "number"
                                        placeholder = "Enter the Price"
                                        name = "price"
                                        className = "form-control"
                                        value = {price}
                                        onChange = {(e) => setPrice(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Availability</label>
                                    <input
                                        type = "number"
                                        placeholder = "Enter the Availability"
                                        name = "availability"
                                        className = "form-control"
                                        value = {avail}
                                        onChange = {(e) => setAvail(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <button className = "btn btn-success" onClick = {(e) => Addition(e)} >Submit </button>
                                <Link to="/ProductsList" className="btn btn-danger"> Cancel </Link>
                            </form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}

export default AddProduct