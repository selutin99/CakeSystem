package com.cake.system.controllers;

import com.cake.system.entity.Customers;
import com.cake.system.service.CRUD.CustomersService;

import java.util.List;

public class CustomersController {
    private CustomersService service;

    public CustomersController(){
        this.service = new CustomersService();
    }

    public void add(Customers data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.add(data);
    }

    public void edit(Customers data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.edit(data);
    }

    public void delete(Customers data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.service.delete(data);
    }

    public List<Customers> getAll(){
        return this.service.getAll();
    }

    public Customers find(int id){
        return this.service.find(id);
    }
}
