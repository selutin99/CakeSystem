package com.cake.system.controllers;

import com.cake.system.entity.Characteristics;
import com.cake.system.service.CRUD.CharacteristicsService;

import java.util.List;

public class CharacteristicsController {
    private CharacteristicsService service;

    public CharacteristicsController(){
        this.service = new CharacteristicsService();
    }

    public void add(Characteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(Characteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(Characteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<Characteristics> getAll(){
        return this.service.getAll();
    }

    public Characteristics find(int id){
        return this.service.find(id);
    }
}
