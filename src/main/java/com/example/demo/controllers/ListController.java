package com.example.demo.controllers;

import java.util.List;

import com.example.demo.services.*;
import com.example.demo.entities.Item;
import com.example.demo.entities.Lista; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/l")
public class ListController{

    @Autowired
    private ListService listService;

    @GetMapping("/{listId}")    //  GET LIST
    public Lista getList(
        @PathVariable Integer listId 
    ) {
        System.out.println("listId");
        if(listId >= 0)    return listService.getList(listId);
        else return null;
    }

    @GetMapping("") //  GET ALL LISTS
    public List<Lista> getLists() {
        return listService.getAllLists();
    }

    @PostMapping("")    //  ADD LIST
    public Lista addList(@RequestBody Lista reqBody){       
        return listService.addList(reqBody);
    }

    @PostMapping("/{listId}/i") //  ADD ITEM
    public Lista addItem(
        @RequestBody Item itemDetails, 
        @PathVariable Integer listId
    ){
        System.out.println(listId);
        return listService.addItem(itemDetails, listId);
    }

    @DeleteMapping("/{listId}/i/{itemId}")  //  DELETE ITEM
    public Integer deleteItem(
        @PathVariable Integer listId,
        @PathVariable Integer itemId
    ){
        listService.deleteItem(listId, itemId);
        return null;
    }

    @DeleteMapping("/{listId}") //  DELETE LIST
    public Integer deleteList(
        @PathVariable Integer listId
    ){
        return listService.deleteList(listId);
    }

    @PutMapping("/{listId}")    //  UPDATE LIST
    public Lista truncateList(
        @PathVariable Integer listId
    ){
        return listService.truncateList(listId);
    }

}