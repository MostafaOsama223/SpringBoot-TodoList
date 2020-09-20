package com.example.demo.controllers;

import java.util.List;

import com.example.demo.services.*;
import com.example.demo.entities.Item;
import com.example.demo.entities.Lista; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController{

    @Autowired
    private ListService listService;

    @GetMapping("/l/{listId}")
    public Lista getList(
        @PathVariable Integer listId 
    ) {
        System.out.println("listId");
        if(listId >= 0)    return listService.getList(listId);
        else return null;
    }

    @GetMapping("/l")
    public List<Lista> getLists() {
        return listService.getAllLists();
    }

    @PostMapping("/l")
    public Lista addList(@RequestBody Lista reqBody){       
        return listService.addList(reqBody);
    }

    @PostMapping("/l/{listId}/i")
    public Lista addItem(
        @RequestBody Item itemDetails, 
        @PathVariable Integer listId
    ){
        System.out.println(listId);
        return listService.addItem(itemDetails, listId);
    }

    @DeleteMapping("/l/{listId}/i/{itemId}")
    public Integer deleteItem(
        @PathVariable Integer listId,
        @PathVariable Integer itemId
    ){
        listService.deleteItem(listId, itemId);
        return null;
    }

    @DeleteMapping("/l/{listId}")
    public Integer deleteList(
        @PathVariable Integer listId
    ){
        return listService.deleteList(listId);
    }

    @PutMapping("/l/{listId}")
    public Lista truncateList(
        @PathVariable Integer listId
    ){
        return listService.truncateList(listId);
    }

}