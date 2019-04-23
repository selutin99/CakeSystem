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
        if(name!=null && !name.trim().isEmpty()){
            this.repo.create(new Decorations(id, name, price));
        }
        else{
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void edit(int id, String name, float price){
        if(name!=null && !name.trim().isEmpty()){
            this.repo.edit(new Decorations(id, name, price));
        }
        else{
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void delete(int id, String name, float price){
        if(name!=null && !name.trim().isEmpty()) {
            this.repo.delete(new Decorations(id, name, price));
        }
        else{
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public List<Decorations> getAll(){
        return this.repo.getAll();
    }

    public Decorations find(int id){
        return this.repo.find(id);
    }
}
