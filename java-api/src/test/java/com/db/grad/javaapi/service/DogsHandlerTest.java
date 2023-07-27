package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Dog1");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Dog2");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Dog3");
        cut.addDog(dog3);

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void get_dog_by_name_null_if_no_dogs() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // act
        Dog actualResult = cut.getDogByName("Dog");
        Dog expectedResult = null;

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_dog_by_name_returns_null_when_many_dogs_with_same_name() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Dog1");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Dog1");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Dog3");
        cut.addDog(dog3);

        Dog expectedDog = dog1;
        String dogToFind = "Dog1";

        // act
        Dog actualResult = cut.getDogByName(dogToFind);

        // assert
        assertNull(actualResult);
    }

    @Test
    public void find_dog_by_valid_id_returns_one_dog() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Dog1");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Dog2");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Dog3");
        cut.addDog(dog3);
        long dogId = cut.addDog(dog1);
        Dog expectedDog = dog1;

        // act
        Dog actualResult = cut.getDogById(dogId);

        // assert
        assertEquals(expectedDog.getId(), actualResult.getId());
        assertEquals(expectedDog.getName(), actualResult.getName());

    }

    @Test
    public void add_dog_and_remove_dog_return_number_of_dogs_is_zero() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        long dogId = cut.addDog(theDog);

        long expectedResult = 0;
        boolean expectedStatus = true;


        // act
        boolean actualStatus = cut.removeDog(dogId);
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(expectedStatus, actualStatus);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void update_dog_that_exists_returns_dog_id() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        long expectedResult = cut.addDog(theDog);
        Dog dogToUpdate = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        // act
        dogToUpdate.setName("Charlie");
        long actualResult = cut.updateDogDetails(dogToUpdate);

        // assert
        assertEquals(expectedResult, actualResult);

    }
}


