package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    private String header;
    private String description;
    private String priority;
    private String[] label;
    private boolean completed;

    // @OneToOne
    // Lista list;

    public Item(){
        
    }

    public Item(Item item){
        this.itemId = item.itemId;
        this.header = item.header;
        this.priority = item.priority;
        this.label = item.label;
        this.completed = item.completed;
    }

    public Item(Integer itemId, String header, String description, String priority, String[] label, boolean completed){
        this.itemId = itemId;
        this.header = header;
        this.priority = priority;
        this.label = label;
        this.completed = completed;
    }


    public void setitemId(Integer itemId){
        this.itemId = itemId;
    }

    public void setHeader(String header){
        this.header = header;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public void setLabel(String[] label){
        this.label = label;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    // public void setLista(Lista list){
    //     this.list = list;
    // }

    public Integer getitemId(){
        return itemId;
    }

    public String getHeader(){
        return header;
    }

    public String getDescription(){
        return description;
    }

    public String getPriority(){
        return priority;
    }

    public String[] getLabel(){
        return label;
    }

    public boolean getCompleted(){
        return completed;
    }

    // public Lista getLista(){
    //     return this.list;
    // }



}
