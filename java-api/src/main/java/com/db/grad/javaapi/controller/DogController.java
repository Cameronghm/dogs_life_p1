package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.db.grad.javaapi.model.*;

import java.util.List;

@RestController

@CrossOrigin(origins="http://localhost:3000")
public class DogController {

  @Autowired
  DogService dogService;

  @GetMapping("/")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }

  @GetMapping("/dogs/count")
  public long countDogs() {return dogService.countDogs();}

  @GetMapping("/dogs/all")
  public List<Dog> getAllDogs() {return dogService.getAllDogs();}

  @GetMapping("/dogs/name/{name}")
  public Dog getDogByName(@PathVariable String name) {return dogService.getDogByName(name);}

  @GetMapping("/dogs/id/{id}")
  public Dog getDogById(@PathVariable String id) {return dogService.getDogByid(id);}

  @PostMapping("/dogs/modify")
  public HttpStatus modify(@RequestBody Dog dog)
  {
    int modification = dogService.modify(dog);
    if(modification==0)
    {
      return HttpStatus.PRECONDITION_FAILED;
    }
    else
    {
      return HttpStatus.ACCEPTED;
    }
  }

  @DeleteMapping("/delete/id/{id}")
  public HttpStatus deleteDogId(@PathVariable String id) {
    if(dogService.removeDogid(id)!=0)
    {
      return HttpStatus.ACCEPTED;
    }
    else
    {
      return HttpStatus.PRECONDITION_FAILED;
    }
  }

  @DeleteMapping("/delete/name/{name}")
  public HttpStatus deleteDogName(@PathVariable String name) {
    if(dogService.removeDogName(name)!=0)
    {
      return HttpStatus.ACCEPTED;
    }
    else
    {
      return HttpStatus.PRECONDITION_FAILED;
    }
  }

  @PostMapping("/add")
  public HttpStatus save(@RequestBody Dog dog)
  {
    if(dogService.saveDog(dog)!=null)
    {
      return HttpStatus.ACCEPTED;
    }
    else
    {
      return HttpStatus.PRECONDITION_FAILED;
    }
  }

  @GetMapping("/dogs/owners/name/{name}")
  public String getOwnerName(@PathVariable String name) {return dogService.getOwnerName(name);}

  @GetMapping("/dogs/owners/id/{id}")
  public String getOwnerId(@PathVariable String id) {return dogService.getOwnerId(id);}

}
