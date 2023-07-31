import http from './axios-common';

export function getAllHeroes(){
    return http.get("/heroes");
}

export function saveHero(hero){
    return http.post("/heroes", hero)
}