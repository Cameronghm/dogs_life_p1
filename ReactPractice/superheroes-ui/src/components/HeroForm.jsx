import React from 'react'
import Form from 'react-bootstrap/Form'
import Row  from 'react-bootstrap/Row';
import Button  from 'react-bootstrap/Button';

const HeroForm = () => {
  return (
    <Row className='heroForm'>
        <Form >
            <Form.Group className="mb-3" controlId="alias">
                <Form.Label>Hero Alias: </Form.Label>
                <Form.Control type="text" placeholder="Hero alias" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="name">
                <Form.Label>Hero Name: </Form.Label>
                <Form.Control type="text" placeholder="Hero name" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="ability">
                <Form.Label>Hero Ability: </Form.Label>
                <Form.Control type="text" placeholder="Hero ability" />
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