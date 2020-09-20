package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.repositories.ItemRepo;
import com.example.demo.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    
    @Autowired
    ItemRepo itemRepo;

    public ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<Item>();
        itemRepo.findAll().forEach(item -> items.add(item));
        return items;
    }

    public Item addItem(Item item, Integer listId){
        return item;
    }
}
