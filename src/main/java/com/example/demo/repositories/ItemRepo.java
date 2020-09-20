package com.example.demo.repositories;

import com.example.demo.entities.Item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer>{
    
}
