package com.cake.system.service.CRUD;

import com.cake.system.entity.Customers;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.service.Connection;

import java.util.List;

public class CustomersService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWork<Customers> repo;

    public CustomersService(){
        this.repo = con.getCustomersRepo();
    }

    public void add(int id, String firstName, String lastName){
        if(firstName!=null && !firstName.trim().isEmpty() && lastName!=null && !lastName.trim().isEmpty()){
            this.repo.create(new Customers(id, firstName, lastName));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void edit(int id, String firstName, String lastName){
        if(firstName!=null && !firstName.trim().isEmpty() && lastName!=null && !lastName.trim().isEmpty()){
            this.repo.edit(new Customers(id, firstName, lastName));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void delete(int id, String firstName, String lastName){
        if(firstName!=null && !firstName.trim().isEmpty() && lastName!=null && !lastName.trim().isEmpty()){
            this.repo.delete(new Customers(id, firstName, lastName));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public List<Customers> getAll(){
        return this.repo.getAll();
    }

    public Customers find(int id){
        return this.repo.find(id);
    }
}
