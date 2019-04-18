package com.cake.system.controllers;

import com.cake.system.entity.Customers;
import com.cake.system.entity.Decorations;
import com.cake.system.service.CRUD.CustomersService;
import com.cake.system.service.CRUD.DecorationsService;

import java.util.List;

public class DecorationsController {
    private DecorationsService service;

    public DecorationsController(){
        this.service = new DecorationsService();
    }

    public void add(Decorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(Decorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(Decorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<Decorations> getAll(){
        return this.service.getAll();
    }

    public Decorations find(int id){
        return this.service.find(id);
    }
}
