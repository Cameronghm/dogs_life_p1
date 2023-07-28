package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query(nativeQuery = true, value = "select count(*) from dogs")
    List<Dog> findNUmberOfDogs();

    @Query(nativeQuery = true, value = "select * from dogs where name = dogName")
    Dog findDogBySpecificName(String dogName);

    @Query(nativeQuery = true, value = "select * from dogs where id = dogId")
    Dog findDogBySpecificId(String dogId);

    @Query(nativeQuery = true, value = "update dogs set name = dogName where id = dogId")
    Dog modifyDogNameById(String dogName, long dogId);

    /*@Query(nativeQuery = true, value = "delete from dogs where id = dogId")
    boolean */
}
