package com.cake.system.controllers;

import com.cake.system.entity.CakesBases;
import com.cake.system.service.CRUD.CakesBasesService;

import java.util.List;

public class CakesBasesController {
    private CakesBasesService service;

    public CakesBasesController(){
        this.service = new CakesBasesService();
    }

    public void add(CakesBases data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(CakesBases data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(CakesBases data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<CakesBases> getAll(){
        return this.service.getAll();
    }

    public CakesBases find(int id){
        return this.service.find(id);
    }
}
