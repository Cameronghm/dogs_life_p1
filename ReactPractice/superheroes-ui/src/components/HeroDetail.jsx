import React from 'react';
import images from '../index'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const HeroDetail = (props) => {
  return (
    <Card >
      <div className="imgContainer">
        <Card.Img variant="top" src={images[props.info.alias.replaceAll(/\s/g,'')]} width="150px" />
      </div>
      <Card.Body >
        <Card.Title >Alias: {props.info.alias}</Card.Title>
        <Card.Text >Name: {props.info.name}</Card.Text>
        <Button variant="primary">Like</Button>
      </Card.Body>
    </Card>
  )
}

export default HeroDetail