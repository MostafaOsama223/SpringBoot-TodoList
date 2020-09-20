package com.example.demo.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Lista {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "li_fk", referencedColumnName = "id")
    public List<Item> items = new LinkedList<>();

    public Lista(){

    }

    public Lista(Integer id, String name, List<Item> items){
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public Lista(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Lista(String name){
        this.name = name;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Item> getItem(){
        return this.items;
    }

    public void setItem(List<Item> item){
        this.items = item;
    }

}
