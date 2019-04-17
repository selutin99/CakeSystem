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

    public void add(Decorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(Decorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(Decorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<Decorations> getAll(){
        return this.repo.getAll();
    }

    public Decorations find(int id){
        return this.repo.find(id);
    }
}
