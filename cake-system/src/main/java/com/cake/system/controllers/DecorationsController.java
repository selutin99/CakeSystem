package com.cake.system.controllers;

import com.cake.system.entity.Decorations;
import com.cake.system.service.CRUD.DecorationsService;

import java.util.List;

public class DecorationsController {
    private DecorationsService service;

    public DecorationsController(){
        this.service = new DecorationsService();
    }

    public void add(int id, String name, float price){
        this.service.add(id, name, price);
    }

    public void edit(int id, String name, float price){
        this.service.edit(id, name, price);
    }

    public void delete(int id, String name, float price){
        this.service.delete(id, name, price);
    }

    public List<Decorations> getAll(){
        return this.service.getAll();
    }

    public Decorations find(int id){
        return this.service.find(id);
    }
}
