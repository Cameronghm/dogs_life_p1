import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import { useEffect, useState } from 'react';

const DogDetail = (props) => {
  const [ownersId, setOwnersId] = useState(false);
  

  const makeOwnersIdVisible = () => {
    setOwnersId(current => !current);
  }

  useEffect(() => {
    console.log(ownersId);
  }, [ownersId]);

  return (
    <Card>
      <Card.Body>
        <Card.Title>Dog's Name: {props.info.name}</Card.Title>
        <Card.Text>Dog's Age: {props.info.age}</Card.Text>
        <Card.Text>Dog's ID: {props.info.id}</Card.Text>
        <Button variant="primary" onClick={makeOwnersIdVisible}>Show Owner's Id</Button>
        {ownersId &&
        <Card.Text>Owner's ID: {props.info.owner_id}</Card.Text>
         
        }
      </Card.Body>
    </Card>
  )

}
export default DogDetail




