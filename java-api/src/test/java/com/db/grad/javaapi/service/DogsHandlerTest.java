package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.*;
import com.db.grad.javaapi.model.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Add a Dog, Return Number of Dogs")
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
}
