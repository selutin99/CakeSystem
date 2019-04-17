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

    public void add(Customers data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(Customers data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(Customers data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<Customers> getAll(){
        return this.repo.getAll();
    }

    public Customers find(int id){
        return this.repo.find(id);
    }
}
