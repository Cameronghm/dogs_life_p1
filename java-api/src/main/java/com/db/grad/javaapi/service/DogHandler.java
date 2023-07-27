package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {

    private DogsRepository itsDogsRepo;

    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(String name) {
        Dog dog = new Dog();
        dog.setName(name);
        List<Dog> dogs = itsDogsRepo.findByName(dog);

        if (dogs.size() == 1) {
            return dogs.get(0);
        } else {
            return null;
        }
    }

    public Dog getDogById(long dogId) {
        return itsDogsRepo.findById(dogId);
    }

    public boolean removeDog(long uniqueId) {
        boolean result = false;

        Dog theDog = itsDogsRepo.findById(uniqueId);
        if (theDog != null) {
            result = itsDogsRepo.delete(theDog);
        }

        return result;
    }

    public long updateDogDetails(Dog theDog) {
        if (!itsDogsRepo.existsById(theDog.getId())) {
            return -1;
        } else {
            return itsDogsRepo.save(theDog);
        }
    }
}
