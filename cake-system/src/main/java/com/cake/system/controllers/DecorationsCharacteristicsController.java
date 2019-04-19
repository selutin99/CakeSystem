package com.cake.system.controllers;

import com.cake.system.entity.associations.DecorationsCharacteristics;
import com.cake.system.service.CRUD.DecorationsCharacteristicsService;

import java.util.List;

public class DecorationsCharacteristicsController {
    private DecorationsCharacteristicsService service;

    public DecorationsCharacteristicsController(){
        this.service = new DecorationsCharacteristicsService();
    }

    public void add(int first, int second){
        this.service.add(first, second);
    }

    public void edit(int first, int second){
        this.service.edit(first, second);
    }

    public void delete(int first, int second){
        this.service.delete(first, second);
    }

    public List<DecorationsCharacteristics> getAll(){
        return this.service.getAll();
    }

    public DecorationsCharacteristics find(int first, int second){
        return this.service.find(first, second);
    }
}
