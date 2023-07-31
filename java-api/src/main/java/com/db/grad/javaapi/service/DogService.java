package com.db.grad.javaapi.service;


import com.db.grad.javaapi.repository.DogRepository;
import com.db.grad.javaapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    private DogRepository itsDogRepo;

    public DogService(DogRepository itsDogRepo) {
        this.itsDogRepo = itsDogRepo;
    }

    public long countDogs() {
        return itsDogRepo.findNumberOfDogs();
    }

    public List<Dog> getAllDogs() {
        return itsDogRepo.findAll();
    }

    public Dog getDogByName(String name) {
        List<Dog> dogList = itsDogRepo.findDogBySpecificName(name);
        if (dogList.size() == 1) {
            return dogList.get(0);
        } else {
            return null;
        }
    }

    public Dog getDogByid(String id) {
        List<Dog> dogList = itsDogRepo.findDogBySpecificId(id);
        if (dogList.size() == 1) {
            return dogList.get(0);
        } else {
            return null;
        }
    }

    public long modify(Dog dog) {
        return itsDogRepo.modifyDog(dog.getId(),
                dog.getName(),
                dog.getAge(),
                Long.parseLong(dog.getOwner_id()));
    }

    public long removeDogid(String id) {
        return itsDogRepo.deleteDogId(Long.parseLong(id));
    }

    public long removeDogName(String name) {
        return itsDogRepo.deleteDogName(name);
    }

    public long save(Dog dog) {
        return itsDogRepo.addDog(dog.getName(), dog.getAge(), Long.parseLong(dog.getOwner_id()));
    }

    public String getOwnerName(String name) {
        List<String> owners = itsDogRepo.getOwnerName(name);
        String listOfOwners = "";
        for (String owner : owners) {
            listOfOwners = listOfOwners + owner;
        }
        return listOfOwners;
    }

    public String getOwnerId(String id) {
        List<String> owners = itsDogRepo.getOwnerId(Long.parseLong(id));
        String listOfOwners = "";
        for (String owner : owners) {
            listOfOwners = listOfOwners + owner;
        }
        return listOfOwners;
    }
}