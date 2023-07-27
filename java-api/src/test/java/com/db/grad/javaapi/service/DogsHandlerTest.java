package com.db.grad.javaapi.service;
import java.util.Random;

import com.db.grad.javaapi.repository.*;
import com.db.grad.javaapi.model.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;


import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();
    @BeforeEach
    public void makeSureRepoIsEmpty()
    {
        itsDogRepo.deleteAll();
    }
    @Test
    @DisplayName("1. Add a Dog, Return Number of Dogs")
    public void add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        theDog.setName("Karisa");
        cut.addDog(theDog);
        int expectedResult=1;

        long actualResult = cut.getNoOfDogs();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("2. Add Several dogs, return number of dogs added")
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Random randomNumber = new Random();
        int maxNum = 25;
        int randomInt = randomNumber.nextInt(maxNum);

        for(int dog = 0; dog <= randomInt; dog++)
        {
            Dog theDog = new Dog();
            cut.addDog(theDog);

        }
        long actualResult = cut.getNoOfDogs();
        int expectedResult = randomInt+1;

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("3. Get Dog by name, return dog if one, otherwise null (No Dogs)")
    public void get_dog_by_name_null_no_dogs()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog actualResult = cut.getDogByName("Happy");
        Dog expectedResult = null;

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("4. Get Dog by name, return dog if one, otherwise null (Multiple Dogs Same Name)")
    public void get_dog_by_name_null_multiple_dogs()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog1 = new Dog();
        theDog1.setName("Happy");
        cut.addDog(theDog1);
        Dog theDog2 = new Dog();
        theDog2.setName("Happy");
        cut.addDog(theDog2);
        Dog actualResult = cut.getDogByName("Happy");
        Dog expectedResult = null;

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("5. Get Dog by name, return dog if one, otherwise null (Single Dog Same Name)")
    public void get_dog_by_name_null_single_dog()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog1 = new Dog();
        theDog1.setName("Happy");
        cut.addDog(theDog1);
        Dog returned = cut.getDogByName("Happy");

        // Assert
        assertTrue("Check", returned.getName().equals("Happy"));
    }

    @Test
    @DisplayName("6. Get Dog by name, return dog if one, otherwise null (Multiple Dogs One Name)")
    public void get_dog_by_name_null_multiple_dogs_single_name()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog1 = new Dog();
        theDog1.setName("Happy");
        cut.addDog(theDog1);
        Dog theDog2 = new Dog();
        theDog2.setName("Happier");
        cut.addDog(theDog2);
        Dog theDog3 = new Dog();
        theDog3.setName("Very Happy");
        cut.addDog(theDog3);
        Dog returned = cut.getDogByName("Happy");

        // Assert
        assertTrue("Check", returned.getName().equals("Happy"));
    }

    @Test
    @DisplayName("7. Get Dog By ID (exists)")
    public void get_dog_by_id_exists()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        long theDogid = cut.addDog(theDog);
        Dog theDog2 = new Dog();
        cut.addDog(theDog2);
        Dog dogByid = cut.getDogByid(theDogid);

        // Assert
        assertTrue("Test", dogByid!=null);
    }

    @Test
    @DisplayName("8. Get Dog By ID (!exists)")
    public void get_dog_by_id_not_exists()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        long theDogid = cut.addDog(theDog);
        Dog dogByid = cut.getDogByid(theDogid+1);

        // Assert
        assertTrue("Test", dogByid==null);
    }

    @Test
    @DisplayName("9. Update Dog Details (!Exists)")
    public void update_dog_details_not_exists()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        long theDogid = cut.addDog(theDog);
        Dog otherDog = new Dog();
        otherDog.setId(theDogid+1);
        long changedid = cut.updateDogDetails(otherDog);
        int expectedResult = -1;

        // Assert
        assertEquals(expectedResult, changedid);
    }

    @Test
    @DisplayName("10. Update Dog Details (Exists)")
    public void update_dog_details_exists()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        long theDogid = cut.addDog(theDog);
        theDog.setName("Carly");
        theDog.setId(theDogid);
        long changedid = cut.updateDogDetails(theDog);

        // Assert
        assertEquals(theDogid, changedid);
    }

    @Test
    @DisplayName("11. Remove Dog (Exists)")
    public void remove_dog_exists()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        long id = cut.addDog(theDog);
        boolean removed = cut.removeDog(theDog);

        // Assert
        assertTrue("Check if Dog is removed", removed);
    }

    @Test
    @DisplayName("12. Remove Dog (Doesn't Exists)")
    public void remove_dog_not_exists()
    {
        // Arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        // Act
        Dog theDog = new Dog();
        long id = cut.addDog(theDog);
        cut.removeDog(theDog);
        boolean removed = cut.removeDog(theDog);

        // Assert
        assertTrue("Check if Dog is not removed", !removed);
    }
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one () {
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
}
