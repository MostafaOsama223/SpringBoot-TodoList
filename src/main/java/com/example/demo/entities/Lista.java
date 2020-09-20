package com.example.demo.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Lista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer listId;
    private String listHeader;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "li_fk", referencedColumnName = "listId")
    public List<Item> items = new LinkedList<>();

    public Lista(){

    }

    public Lista(Integer listId, String listHeader, List<Item> items){
        this.listId = listId;
        this.listHeader = listHeader;
        this.items = items;
    }

    public Lista(Integer listId, String listHeader){
        this.listId = listId;
        this.listHeader = listHeader;
    }

    public Lista(String listHeader){
        this.listHeader = listHeader;
    }

    public Integer getListId(){
        return this.listId;
    }

    public String getListHeader(){
        return this.listHeader;
    }

    public void setListId(Integer listId){
        this.listId = listId;
    }

    public void setlistHeader(String listHeader){
        this.listHeader = listHeader;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public void setItems(List<Item> item){
        this.items = item;
    }

}
