package com.cake.system.controllers;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.service.CRUD.CakesCharacteristicsService;
import com.cake.system.service.CRUD.CakesDecorationsService;

import java.util.List;

public class CakesDecorationsController {
    private CakesDecorationsService service;

    public CakesDecorationsController(){
        this.service = new CakesDecorationsService();
    }

    public void add(CakesDecorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(CakesDecorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(CakesDecorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<CakesDecorations> getAll(){
        return this.service.getAll();
    }

    public CakesDecorations find(int first, int second){
        return this.service.find(first, second);
    }
}
