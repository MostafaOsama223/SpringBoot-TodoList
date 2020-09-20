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
    private String itemHeader;
    private String description;
    private String itemPriority;
    private String[] itemLabel;
    private boolean itemCompleted;

    // @OneToOne
    // Lista list;

    public Item(){
        
    }

    public Item(Item item){
        this.itemId = item.itemId;
        this.itemHeader = item.itemHeader;
        this.itemPriority = item.itemPriority;
        this.itemLabel = item.itemLabel;
        this.itemCompleted = item.itemCompleted;
    }

    public Item(Integer itemId, String itemHeader, String description, String itemPriority, String[] itemLabel, boolean itemCompleted){
        this.itemId = itemId;
        this.itemHeader = itemHeader;
        this.itemPriority = itemPriority;
        this.itemLabel = itemLabel;
        this.itemCompleted = itemCompleted;
    }


    public void setitemId(Integer itemId){
        this.itemId = itemId;
    }

    public void setHeader(String itemHeader){
        this.itemHeader = itemHeader;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(String itemPriority){
        this.itemPriority = itemPriority;
    }

    public void setLabel(String[] itemLabel){
        this.itemLabel = itemLabel;
    }

    public void setCompleted(boolean itemCompleted){
        this.itemCompleted = itemCompleted;
    }

    // public void setLista(Lista list){
    //     this.list = list;
    // }

    public Integer getItemId(){
        return this.itemId;
    }

    public String getItemHeader(){
        return this.itemHeader;
    }

    public String getItemDescription(){
        return this.description;
    }

    public String getItemPriority(){
        return this.itemPriority;
    }

    public String[] getItemLabel(){
        return this.itemLabel;
    }

    public boolean getItemCompleted(){
        return this.itemCompleted;
    }

    // public Lista getLista(){
    //     return this.list;
    // }



}
