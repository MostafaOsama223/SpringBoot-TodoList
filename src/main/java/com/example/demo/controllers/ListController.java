package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import com.example.demo.services.*;
import com.example.demo.entities.Item;
import com.example.demo.entities.Lista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController{

    @Autowired
    private ListService listService;

    @GetMapping("/l")
    public List<Lista> getList(
        @RequestParam(name = "id", required = false, defaultValue = "null") String id 
    ) {
        if(id.contentEquals("null"))    return listService.getAllLists();
        else    return Arrays.asList(listService.getList(Integer.parseInt(id)));
    }

    @PostMapping("/l")
    public Lista postList(@RequestBody Lista reqBody){       
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

}