import React from 'react'
import HeroDetail from './HeroDetail'

const AllHeroes = () => {

    const hero = {
        "id":1,
        "name":"Bruce Wayne",
        "alias":"Batman",
        "superpower":"Martial Arts",
        "teamID":1
}
  return (
    <HeroDetail info={hero}/>
  )
}

export default AllHeroes