import React from 'react';
import HeroDetail from './HeroDetail';
import Row from 'react-bootstrap/Row';

const AllHeroes = () => {
  const heroes = 
  [
    {"id":1,"name":"Bruce Wayne","alias":"Batman","superpower":"Martial Arts","teamID":1},
    {"id":2,"name":"Clark Kent","alias":"Superman","superpower":"Flight","teamID":1},
    {"id":3,"name":"Jay Garrick","alias":"The Flash","superpower":"Super-speed","teamID":2},
    {"id":4,"name":"Alan Scott","alias":"Green Lantern","superpower":"Ring Creation","teamID":2},
    {"id":5,"name":"Helena Bertenelli","alias":"The Huntress","superpower":"Crossbow Archery","teamID":3},
    {"id":6,"name":"Dr. Harleen Quinzel","alias":"Harley Quinn","superpower":"Hammer-fighting","teamID":3},
    {"id":7,"name":"Floyd Lawton","alias":"Deadshot","superpower":"Marksmaship","teamID":4},
    {"id":8,"name":"Cecil Adams","alias":"Count Vertigo","superpower":"Drug-dealing","teamID":4},
    {"id":9,"name":"Damian Wayne","alias":"Robin","superpower":"Swordsmanship","teamID":5},
    {"id":10,"name":"Dick Grayson","alias":"Nightwing","superpower":"Acrobatics","teamID":5}
  ];
  return (
    <Row >
      {heroes.map(hero => (
        <div className="container" key={hero.id}>
          <HeroDetail info={hero}/>
        </div>
        )
      )}
    </Row>
  )
  
}

export default AllHeroes