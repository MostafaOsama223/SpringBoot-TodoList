package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Lista;
import com.example.demo.repositories.ListRepo;
import com.example.demo.entities.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    private ListRepo listRepo;

    public List<Lista> getAllLists() {
        List<Lista> lists = new ArrayList<>();
        listRepo.findAll().forEach(list -> lists.add(list));
        return lists;
    }

    public Lista getList(Integer id) {
        return listRepo.findById(id).get();
    }

    public Lista addList(Lista List) {
        listRepo.save(List);
        return List;
    }

    public Lista addItem(Item itemDetails, Integer listId) {
        Lista parentList = listRepo.findById(listId).get();
        ArrayList<Item> newItems = new ArrayList<>();
        newItems.add(itemDetails);
        // System.out.println("A");
        newItems.addAll(parentList.getItem());
        // System.out.println("B");
        listRepo.save(new Lista(listId, parentList.getName(), newItems));
        // System.out.println("C");
        return getList(listId);
    }

}
