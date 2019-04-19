package com.cake.system.service.CRUD;

import com.cake.system.entity.CakesBases;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.service.Connection;

import java.util.List;

public class CakesBasesService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWork<CakesBases> repo;

    public CakesBasesService(){
        this.repo = con.getCakesBasesRepo();
    }

    public void add(int id, String name){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(new CakesBases(id, name));
    }

    public void edit(int id, String name){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(new CakesBases(id, name));
    }

    public void delete(int id, String name){
        if(name==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(new CakesBases(id, name));
    }

    public List<CakesBases> getAll(){
        return this.repo.getAll();
    }

    public CakesBases find(int id){
        return this.repo.find(id);
    }
}
