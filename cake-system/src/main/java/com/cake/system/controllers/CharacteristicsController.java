package com.cake.system.controllers;

import com.cake.system.entity.Characteristics;
import com.cake.system.service.CRUD.CharacteristicsService;

import java.util.List;

public class CharacteristicsController {
    private CharacteristicsService service;

    public CharacteristicsController(){
        this.service = new CharacteristicsService();
    }

    public void add(int id, String name, String value){
        this.service.add(id, name, value);
    }

    public void edit(int id, String name, String value){
        this.service.edit(id, name, value);
    }

    public void delete(int id, String name, String value){
        this.service.delete(id, name, value);
    }

    public List<Characteristics> getAll(){
        return this.service.getAll();
    }

    public Characteristics find(int id){
        return this.service.find(id);
    }
}
