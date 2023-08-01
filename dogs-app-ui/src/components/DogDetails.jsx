import React from 'react';
import Card from 'react-bootstrap/Card';

const DogDetail = (props) => {
  return (
    <Card>
        <Card.Body>
        <Card.Title>Dog's Name: {props.info.name}</Card.Title>
        <Card.Text>Dog's Age: {props.info.age}</Card.Text>
        <Card.Text>Dog's ID: {props.info.id}</Card.Text>
        </Card.Body>
    </Card>
  )

}
export default DogDetail

  


