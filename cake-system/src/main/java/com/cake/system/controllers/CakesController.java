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
        this.service.add(id, customerID, name, price, cakeBase);
    }

    public void edit(int id, int customerID, String name, float price, int cakeBase){
        this.service.edit(id, customerID, name, price, cakeBase);
    }

    public void delete(int id, int customerID, String name, float price, int cakeBase){
        this.service.delete(id, customerID, name, price, cakeBase);
    }

    public List<Cakes> getAll(){
        return this.service.getAll();
    }

    public Cakes find(int id){
        return this.service.find(id);
    }
}
