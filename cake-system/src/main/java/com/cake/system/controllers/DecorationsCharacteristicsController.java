package com.cake.system.controllers;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.entity.associations.DecorationsCharacteristics;
import com.cake.system.service.CRUD.CakesCharacteristicsService;
import com.cake.system.service.CRUD.DecorationsCharacteristicsService;

import java.util.List;

public class DecorationsCharacteristicsController {
    private DecorationsCharacteristicsService service;

    public DecorationsCharacteristicsController(){
        this.service = new DecorationsCharacteristicsService();
    }

    public void add(DecorationsCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(DecorationsCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(DecorationsCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<DecorationsCharacteristics> getAll(){
        return this.service.getAll();
    }

    public DecorationsCharacteristics find(int first, int second){
        return this.service.find(first, second);
    }
}
