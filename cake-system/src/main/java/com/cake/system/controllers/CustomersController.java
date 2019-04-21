package com.cake.system.controllers;

import com.cake.system.entity.Customers;
import com.cake.system.service.CRUD.CustomersService;

import java.util.List;

public class CustomersController {
    private CustomersService service;

    public CustomersController(){
        this.service = new CustomersService();
    }

    public void add(int id, String firstName, String lastName){
        this.service.add(id, firstName, lastName);
    }

    public void edit(int id, String firstName, String lastName){
        this.service.edit(id, firstName, lastName);
    }

    public void delete(int id, String firstName, String lastName){
        this.service.delete(id, firstName, lastName);
    }

    public List<Customers> getAll(){
        return this.service.getAll();
    }

    public Customers find(int id){
        return this.service.find(id);
    }
}
