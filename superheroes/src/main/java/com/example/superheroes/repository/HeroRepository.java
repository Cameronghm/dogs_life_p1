package com.example.superheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.superheroes.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    List<Hero> findTop3ByOrderByNameDesc();
    @Query(nativeQuery = true, value="SELECT * FROM Heroes WHERE name LIKE :letter")
    List<Hero> findHeroesNameStartingWithLetter(String letter);
}
