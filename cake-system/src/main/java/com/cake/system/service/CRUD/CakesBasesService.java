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
        if(name!=null && !name.trim().isEmpty() ){
            this.repo.create(new CakesBases(id, name));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void edit(int id, String name){
        if(name!=null && !name.trim().isEmpty() ){
            this.repo.edit(new CakesBases(id, name));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void delete(int id, String name){
        if(name!=null && !name.trim().isEmpty() ){
            this.repo.delete(new CakesBases(id, name));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public List<CakesBases> getAll(){
        return this.repo.getAll();
    }

    public CakesBases find(int id){
        return this.repo.find(id);
    }
}
