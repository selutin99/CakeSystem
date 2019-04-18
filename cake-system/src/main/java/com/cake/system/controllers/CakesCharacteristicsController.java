package com.cake.system.controllers;

import com.cake.system.entity.Characteristics;
import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.service.CRUD.CakesCharacteristicsService;
import com.cake.system.service.CRUD.CharacteristicsService;

import java.util.List;

public class CakesCharacteristicsController {
    private CakesCharacteristicsService service;

    public CakesCharacteristicsController(){
        this.service = new CakesCharacteristicsService();
    }

    public void add(CakesCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(CakesCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(CakesCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<CakesCharacteristics> getAll(){
        return this.service.getAll();
    }

    public CakesCharacteristics find(int first, int second){
        return this.service.find(first, second);
    }
}
