import React from 'react'
import batman from '../images/download.png';

const HeroDetail = () => {
      return (
        <div>
            <img src={batman} alt="Batman" height="250px"/>
            <p id="blue-alias">Alias: Batman</p>
            <p className="green-class">Name: Bruce Wayne</p>
            <button className="green-class">Like</button>   
        </div>
    )
}
export default HeroDetail
