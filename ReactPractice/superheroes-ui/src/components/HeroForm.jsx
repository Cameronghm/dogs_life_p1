import React from 'react';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';

const HeroForm = () => {
  const [alias, setAlias] = useState('');
  const [name, setName] = useState('');
  const [ability, setAbility] = useState('');
  const [teamID, setTeamID] = useState(0);
  const handleAliasChange = (event) => {
    setAlias(event.target.value);
  }
  const handleNameChange = (event) => {
    setName(event.target.value);
  }
  const handleAbilityChange = (event) => {
    setAbility(event.target.value);
  }
  const handleTeamIDChange = (event) => {
    setTeamID(event.target.value);
  }
  const handleSubmit = (event) => {
    event.preventDefault();
    let hero = {};
    hero.alias = alias;
    hero.name = name;
    hero.ability = ability;
    hero.teamID = teamID;
    console.log(hero);
  }
  return (
    <Row className="heroForm">
        <Form>
            <Form.Group className="mb-3" controlId="alias">
                <Form.Label>Hero Alias: </Form.Label>
                <Form.Control type="text" placeholder='Hero Alias' 
                value={alias} onChange={handleAliasChange}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="name">
                <Form.Label>Hero Name: </Form.Label>
                <Form.Control type="text" placeholder='Hero Name' 
                value={name} onChange={handleNameChange}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="ability">
                <Form.Label>Hero Ability: </Form.Label>
                <Form.Control type="text" placeholder='Hero Ability'
                value={ability} onChange={handleAbilityChange}/>
            </Form.Group>
            <Form.Select aria-label="Team ID" value={teamID} onChange={handleTeamIDChange}>
                <option>Team ID</option>
                <option value='1'>One</option>
                <option value='2'>Two</option>
                <option value='3'>Three</option>
            </Form.Select>
            <Button variant="primary" type="submit" onClick={handleSubmit}>Submit</Button>
        </Form>
    </Row>
  )
}

export default HeroForm