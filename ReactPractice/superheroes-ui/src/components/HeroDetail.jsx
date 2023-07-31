import React from 'react';
import batman from '../images/imageofbatman.jpeg'

const HeroDetail = (props) => {
  return (
    <div>
        <img src={batman} alt="Batman" height="250px" />
        <p id="blue-alias">Alias: {props.info.alias}</p>
        <p class="green-class">Name: {props.info.name}</p>
        <button class="green-class">Like</button>
    </div>
  )
}

export default HeroDetail