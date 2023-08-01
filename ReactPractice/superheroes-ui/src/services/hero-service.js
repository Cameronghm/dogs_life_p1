import http from './axios-common';

export function getAllHeroes() {
    return http.get("/heroes");
}

export function saveNewHero(hero) {
    return http.post("/heroes/add", hero);
}