package com.example.demo.controllers;

import com.example.demo.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController{

    @Autowired
    ItemService itemService;

    // @PostMapping("/i/{listId}")
    // public Item addItem(
    //     @RequestBody Item itemDetails, 
    //     @PathVariable Integer listId
    // ){
    //     System.out.println(listId);
    //     ListService.addItem(itemDetails, listId);
    //     // return itemService.addItem(itemDetails, listId);
    // }

    // @GetMapping("/i")
    // public ArrayList<Item> getItem(@RequestParam(name = "id", defaultValue = "null") String id){
    //     return itemService.getItems();
    // }
}