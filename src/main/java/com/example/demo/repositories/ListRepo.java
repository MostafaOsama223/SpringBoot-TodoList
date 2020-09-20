package com.example.demo.repositories;

import com.example.demo.entities.Lista;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends CrudRepository <Lista, Integer> {
    
}
