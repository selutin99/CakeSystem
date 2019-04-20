package com.cake.system.service.CRUD;

import com.cake.system.entity.Cakes;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.service.Connection;

import java.util.List;

public class CakesService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWork<Cakes> repo;

    public CakesService(){
        this.repo = con.getCakesRepo();
    }

    public void add(int id, int customerID, String name, float price, int cakeBase){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(new Cakes(id, name, price, customerID, cakeBase));
    }

    public void edit(int id, int customerID, String name, float price, int cakeBase){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(new Cakes(id, name, price, customerID, cakeBase));
    }

    public void delete(int id, int customerID, String name, float price, int cakeBase){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(new Cakes(id, name, price, customerID, cakeBase));
    }

    public List<Cakes> getAll(){
        return this.repo.getAll();
    }

    public Cakes find(int id){
        return this.repo.find(id);
    }
}
