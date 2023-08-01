package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query(nativeQuery = true, value = "select count(*) from dogs")
    long findNumberOfDogs();

    @Query(nativeQuery = true, value = "select * from dogs where name = ?1")
    List<Dog> findDogBySpecificName(String dogName);

    @Query(nativeQuery = true, value = "select * from dogs where id = ?1")
    List<Dog> findDogBySpecificId(String dogId);

    @Query(nativeQuery = true, value = "update dogs set name=?2, age=?3, owner_id=?4 where id=?1")
    long modifyDog(long id, String name, long age, long owner_id);

    @Query(nativeQuery = true, value = "delete from dogs where id = ?1")
    long deleteDogId(long id);

    @Query(nativeQuery = true, value = "delete from dogs where name = ?1")
    long deleteDogName(String name);

    @Query(nativeQuery = true, value = "insert into dogs dogs (name, age, owner_id) values (?1,?2,?3)")
    long addDog(String name, long age, long owner_id);

    @Query(nativeQuery = true, value = "select o.name as 'Owner Name' from owners inner join dogs on owners.owner_id=dogs.owner_id where dogs.id=?1")
    List<String> getOwnerId(long owner_id);

    @Query(nativeQuery = true, value = "select o.name as 'Owner Name' from owners inner join dogs on owners.owner_id=dogs.owner_id where dogs.name=?1")
    List<String> getOwnerName(String name);
}
