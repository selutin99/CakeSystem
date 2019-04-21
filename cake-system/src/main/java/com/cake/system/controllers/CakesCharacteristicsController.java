package com.cake.system.controllers;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.service.CRUD.CakesCharacteristicsService;

import java.util.List;

public class CakesCharacteristicsController {
    private CakesCharacteristicsService service;

    public CakesCharacteristicsController(){
        this.service = new CakesCharacteristicsService();
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

    public List<CakesCharacteristics> getAll(){
        return this.service.getAll();
    }

    public CakesCharacteristics find(int first, int second){
        return this.service.find(first, second);
    }
}
