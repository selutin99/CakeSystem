package com.cake.system.service.CRUD;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.entity.associations.DecorationsCharacteristics;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.Connection;

import java.util.List;

public class DecorationsCharacteristicsService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWorkAssoc<DecorationsCharacteristics> repo;

    public DecorationsCharacteristicsService(){
        this.repo = con.getDecoCharRepo();
    }

    public void add(DecorationsCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(DecorationsCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(DecorationsCharacteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<DecorationsCharacteristics> getAll(){
        return this.repo.getAll();
    }

    public DecorationsCharacteristics find(int first, int second){
        return this.repo.find(first, second);
    }
}
