import React from 'react'
import Form from 'react-bootstrap/Form'
import Row  from 'react-bootstrap/Row';
import Button  from 'react-bootstrap/Button';
import { useState } from 'react';

const HeroForm = () => {
    const [alias, setAlias] = useState('');
    const [name, setName] = useState('');
    const [ability, setAbility] = useState('');
    const [teamID, setTeamID] = useState(0);

    const handleAliasChange = (event)=> {
        setAlias(event.target.value);
    }

    const handleNameChange = (event)=>{
        setName(event.target.value);
    }

    const handleAbilityChange = (event)=>{
        setAbility(event.target.value)
    }

    const handleTeamChange = (event)=>{
        setTeamID(event.target.value)
    }

  return (
    <Row className='heroForm'>
        <Form >
            <Form.Group className="mb-3" controlId="alias">
                <Form.Label>Hero Alias: </Form.Label>
                <Form.Control type="text" placeholder="Hero alias" value={alias} onChange={handleAliasChange}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="name">
                <Form.Label>Hero Name: </Form.Label>
                <Form.Control type="text" placeholder="Hero name" value={name} onChange={handleNameChange} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="ability" value={ability} onChange={handleAbilityChange}>
                <Form.Label>Hero Ability: </Form.Label>
                <Form.Control type="text" placeholder="Hero ability" value={teamID} onChange={handleTeamChange}/>
            </Form.Group>
            <Form.Select aria-label="Team ID">
                <option>Team ID</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </Form.Select>
            <Button variant="primary" type="submit">Submit</Button>
        </Form>
    </Row>
  )
}

export default HeroForm