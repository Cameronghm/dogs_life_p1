package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;

import java.util.List;

public interface DogsRepository {
    long save(Dog theDog );
    Dog  findById( long id );
    List<Dog> findByName(Dog theDog );
    boolean delete( Dog theDog );
    long count();
    boolean existsById( long id );

    // Additional admin functionality
    void    deleteAll();
}
