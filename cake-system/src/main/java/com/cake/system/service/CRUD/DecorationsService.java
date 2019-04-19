package com.cake.system.service.CRUD;

import com.cake.system.entity.Decorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.service.Connection;

import java.util.List;

public class DecorationsService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWork<Decorations> repo;

    public DecorationsService(){
        this.repo = con.getDecorationsRepo();
    }

    public void add(int id, String name, float price){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(new Decorations(id, name, price));
    }

    public void edit(int id, String name, float price){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(new Decorations(id, name, price));
    }

    public void delete(int id, String name, float price){
        this.repo.delete(new Decorations(id, name, price));
    }

    public List<Decorations> getAll(){
        return this.repo.getAll();
    }

    public Decorations find(int id){
        return this.repo.find(id);
    }
}
