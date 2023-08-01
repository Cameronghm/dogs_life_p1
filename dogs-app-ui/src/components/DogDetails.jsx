import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import { useEffect, useState } from 'react';
import {removeDog} from '../services/dog-service';
import {useNavigate} from 'react-router-dom';

const DogDetail = (props) => {
  const [ownersId, setOwnersId] = useState(false);
  const navigate = useNavigate();

  const makeOwnersIdVisible = () => {
    setOwnersId(current => !current);
  }

  const deleteDog = () => {
    removeDog(props.info.id)
    .then(res => {
      navigate('/dogs');
    })
    .catch(err => {
      console.log(err);
    })
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
        <Button variant="secondary" onClick={deleteDog}>➖Delete</Button>
      </Card.Body>
    </Card>
  )

}
export default DogDetail




