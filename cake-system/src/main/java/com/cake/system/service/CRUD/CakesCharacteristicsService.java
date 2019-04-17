package com.cake.system.service.CRUD;

import com.cake.system.entity.CakesBases;
import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.Connection;

import java.util.List;

public class CakesCharacteristicsService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWorkAssoc<CakesCharacteristics> repo;

    public CakesCharacteristicsService(){
        this.repo = con.getCakesCharRepo();
    }

    public void add(CakesCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(CakesCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(CakesCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<CakesCharacteristics> getAll(){
        return this.repo.getAll();
    }

    public CakesCharacteristics find(int first, int second){
        return this.repo.find(first, second);
    }
}
