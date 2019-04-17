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

    public void add(Cakes data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(Cakes data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(Cakes data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<Cakes> getAll(){
        return this.repo.getAll();
    }

    public Cakes find(int id){
        return this.repo.find(id);
    }
}
