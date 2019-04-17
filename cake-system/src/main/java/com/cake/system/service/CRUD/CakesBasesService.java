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

    public void add(CakesBases data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(CakesBases data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(CakesBases data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<CakesBases> getAll(){
        return this.repo.getAll();
    }

    public CakesBases find(int id){
        return this.repo.find(id);
    }
}
