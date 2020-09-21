package com.example.demo.services;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public Lista getList(Integer listId) {
        return listRepo.findById(listId).get();
    }

    public Lista addList(Lista List) {
        listRepo.save(List);
        return List;
    }

    public Lista addItem(Item itemDetails, Integer listId) {
        Lista parentList = listRepo.findById(listId).get();
        ArrayList<Item> newItems = new ArrayList<>();
        newItems.addAll(parentList.getItems());
        newItems.add(itemDetails);
        listRepo.save(new Lista(listId, parentList.getListHeader(), newItems));
        return getList(listId);
    }

    public Integer deleteList(Integer listId){
        listRepo.deleteById(listId);
        return listId;
    }

    public Integer deleteItem(Integer listId, Integer itemId){
        Lista newList = listRepo.findById(listId).get();
        List<Item> newItems = new LinkedList<>();
        for (Item item : newList.getItems()) {
            if(item.getItemId() != itemId) newItems.add(item);
        }
        newList.setItems(newItems);
        listRepo.save(newList);
        return itemId;
    }

    public Lista truncateList(Integer listId){
        Lista newList = listRepo.findById(listId).get();
        newList.setItems(new LinkedList<>());
        return listRepo.save(newList);
    }

}
