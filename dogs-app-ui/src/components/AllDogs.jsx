import React from 'react'
import DogDetails from './DogDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect } from 'react'
import { getAllDogs, countAllDogs } from '../services/dog-service'


const AllDogs = () => {

  const [total,countDogs]= useState(0);

  const [dogs,setDogs] = useState([]);

  useEffect(()=>{
    getDogsFromAPI();
    countAllDogsFromAPI();}, 
    []);

  const getDogsFromAPI = ()=>{getAllDogs()
    .then(res => {
        setDogs(res.data);
    })
    .catch(err => {
        setDogs([]);
        console.log(err);
    })};
  
  const countAllDogsFromAPI = ()=>{countAllDogs()
      .then(res => {
          countDogs(res.data);
      })
      .catch(err => {
          countDogs();
          console.log(err);
      })};
  return (
    <div>
    <h3> Total number of Dogs are: {total}</h3>
    <Row>
      {
      dogs.map(dog=>(
          <div className='container' key={dog.id.toString()}>
            <DogDetails info={dog}/>
            </div>
        ))}
    </Row>
  </div>  
  )
}

export default AllDogs