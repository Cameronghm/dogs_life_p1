package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.model.*;

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
}
