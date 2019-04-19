package com.cake.system.controllers;

import com.cake.system.entity.Cakes;
import com.cake.system.service.CRUD.CakesService;

import java.util.List;

public class CakesController {
    private CakesService service;

    public CakesController(){
        this.service = new CakesService();
    }

    public void add(int id, int customerID, String name, float price, int cakeBase){
        //TODO я устал и хочу спать
        //this.service.add(id, customerID, name, price, cakeBase);
    }

    public void edit(Cakes data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(Cakes data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<Cakes> getAll(){
        return this.service.getAll();
    }

    public Cakes find(int id){
        return this.service.find(id);
    }
}
