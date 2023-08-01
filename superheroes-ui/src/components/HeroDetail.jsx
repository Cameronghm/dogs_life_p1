import React from 'react';
import images from '../index';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { useState } from 'react';

const HeroDetail = (props) => {

    <img src={images[props.info.alias.replaceAll(/\s/g, '')]} alt={props.info.name} height="200px" />
    const [counter, setCounter] = useState(0);

    const incrementCounter =()=>{
        setCounter(counter+1);
        props.parentCount(props.info.alias);
    }

    return (
        <Card >
            <div className="imgContainer">
                <Card.Img variant="top" src={images[props.info.alias.replaceAll(/\s/g, '')]} width="150px" />
            </div>
            <Card.Body >
                <Card.Title >Alias: {props.info.alias}</Card.Title>
                <Card.Text >Name: {props.info.name}</Card.Text>
                <Card.Text>Likes: {counter}</Card.Text>
                <Row>
                    <Col><Button variant="primary" onClick={incrementCounter}>Like</Button></Col>
                    <Col>{counter > 0 && <Card.Text >Likes: {counter}</Card.Text >}</Col>
                </Row>
            </Card.Body>
        </Card>
    )
}

export default HeroDetail