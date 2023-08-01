
import './App.css';
import React from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';

import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

import AllDogs from './components/AllDogs';
import DogForm from './components/DogForm';
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Dogs</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/allDogs">All Dogs</Nav.Link>
              <Nav.Link href="/dogForm">Dog Form</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      
        <Routes>
          <Route path="allDogs" element={<AllDogs/>} />
          <Route path="dogForm" element={<DogForm/>} />
          <Route path="/" element={<AllDogs/>} />
        </Routes>
    </>
  );
}

export default App;
