import http from './axios-common';

export function getAllDogs(){
    return http.get("/dogs/all");
}

export function countAllDogs(){
    return http.get("/dogs/count");
}


