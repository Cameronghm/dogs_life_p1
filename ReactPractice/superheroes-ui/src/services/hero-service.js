import http from './axios-common';

export function getAllHeroes(){
    return http.get("/heroes");
}