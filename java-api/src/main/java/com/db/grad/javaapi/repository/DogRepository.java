package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query(nativeQuery = true, value = "select count(*) from dogs")
    long findNumberOfDogs();

    @Query(nativeQuery = true, value = "select * from dogs where name = ?1")
    List<Dog> findDogBySpecificName(String dogName);

    @Query(nativeQuery = true, value = "select * from dogs where id = ?1")
    List<Dog> findDogBySpecificId(String dogId);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update dogs set name=?2, age=?3, owner_id=?4 where id=?1")
    int modifyDog(long id, String name, long age, long owner_id);

    @Modifying(clearAutomatically = true)
    long removeById(long id);

    @Modifying(clearAutomatically = true)
    long removeByName(String name);


    Dog save(Dog dog);

    @Query(nativeQuery = true, value = "select Distinct owners.name as \"Owners Name\" From owners inner join dogs on dogs.owner_id=owners.owner_id where dogs.owner_id = ?1")
    List<String> getOwnerId(long owner_id);

    @Query(nativeQuery = true, value = "select Distinct owners.name as \"Owner Name\" from owners inner join dogs on dogs.owner_id=owners.owner_id where dogs.name = ?1")
    List<String> getOwnerName(String name);
}
