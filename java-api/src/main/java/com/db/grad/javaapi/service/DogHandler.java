package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.model.*;

import java.util.List;

public class DogHandler {
    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository itsDogRepo) {
        this.itsDogRepo = itsDogRepo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name)
    {
        Dog sampleDog = new Dog();
        sampleDog.setName(name);
        List<Dog> results = itsDogRepo.findByName(sampleDog);
        if (results.size()==1)
        {
            return results.get(0);
        }
        else
        {
            return null;
        }
    }

    public Dog getDogByid(long theDogid) {
        return itsDogRepo.findById(theDogid);
    }

    public long updateDogDetails(Dog theDog) {
        System.out.println(theDog.getId());
        System.out.println(itsDogRepo.existsById(1));
        System.out.println(itsDogRepo.existsById(2));
        if (!itsDogRepo.existsById(theDog.getId())){
            return -1;
        }
        else {
            return itsDogRepo.save(theDog);
        }
    }
}
