package com.cake.system.controllers;

import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.service.CRUD.CakesDecorationsService;

import java.util.List;

public class CakesDecorationsController {
    private CakesDecorationsService service;

    public CakesDecorationsController(){
        this.service = new CakesDecorationsService();
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

    public List<CakesDecorations> getAll(){
        return this.service.getAll();
    }

    public CakesDecorations find(int first, int second){
        return this.service.find(first, second);
    }
}
