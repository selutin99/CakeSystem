package com.cake.system.controllers;

import com.cake.system.entity.CakesBases;
import com.cake.system.service.CRUD.CakesBasesService;

import java.util.List;

public class CakesBasesController {
    private CakesBasesService service;

    public CakesBasesController(){
        this.service = new CakesBasesService();
    }

    public void add(int id, String name){
        this.service.add(id, name);
    }

    public void edit(int id, String name){
        this.service.edit(id, name);
    }

    public void delete(int id, String name){
        this.service.delete(id, name);
    }

    public List<CakesBases> getAll(){
        return this.service.getAll();
    }

    public CakesBases find(int id){
        return this.service.find(id);
    }
}
