import React from 'react';
import images from '..';

const HeroDetail = (props) => {
  return (
    <div>
      <img src={images[props.info.alias.replaceAll(/\s/g,'')]} alt={props.info.name} height="250px"/>
      <p id="blue-alias">Alias: {props.info.alias}</p>
      <p className="green-class">Name: {props.info.name}</p>
      <button className="green-class">Like</button>  
    </div>
  )
}

export default HeroDetail