import React, {useState, useEffect} from 'react'
import axios from "axios";
import {Link, Navigate, useNavigate, useParams } from 'react-router-dom';
import Service from './Service'

const UpdateProduct = () => {

    const[image,setImage]=useState('');
    const [footwearname, setFootwearname ]= useState('')
    const [brandname, setBrandname] = useState('')
    const [price, setPrice] = useState('')
    const [availability,setAvailability]= useState('')
    const {id} = useParams();
    const navigate=useNavigate();
useEffect(()=>{
    Service.getProductById(id).then((response)=>{
        console.log(response)
        setFootwearname(response.data.footwearname)
        setBrandname(response.data.brandname)
        setPrice(response.data.price)
        setAvailability(response.data.availability)
    }).catch((err)=>{
        console.log(err)
    })
},[])
async function Updation(e){
    e.preventDefault();
    
    Service.updateProduct(id,image,footwearname,brandname,price,availability).then((response)=>{
        console.log(response);
        navigate('/ProductsList')
    }).catch((err)=>{
        console.log(err)
    })
    const res=await axios.get("http://localhost:8790/addto/getitem/" + id);
    if(res.data===1)
    {
        const p=await axios.get("http://localhost:8790/addto/getprice/" +id);
        if(p.data!=price)
        {
          console.log(p.data,"hii",price)
           const f=await axios.put("http://localhost:8790/addto/updatepriceincart/" + id+"/"+price);
           console.log(f.data);
        }
    }
}

    return (
        <div>
           <br /><br />
           <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                       <h2>Update Product</h2>
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
                                    <label className = "form-label">Availability</label>
                                    <input
                                        type = "number"
                                        placeholder = "Enter the Availability"
                                        name = "availability"
                                        className = "form-control"
                                        value = {availability}
                                        onChange = {(e) => setAvailability(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <button className = "btn btn-success" onClick = {(e) => Updation(e)} >Submit </button>
                                <Link to="/ProductsList" className="btn btn-danger"> Cancel </Link>
                            </form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}

export default UpdateProduct