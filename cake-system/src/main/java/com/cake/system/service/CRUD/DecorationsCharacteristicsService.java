package com.cake.system.service.CRUD;

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

    public void add(int first, int second){
        this.repo.create(new DecorationsCharacteristics(first, second));
    }

    public void edit(int first, int second){
        this.repo.edit(new DecorationsCharacteristics(first, second));
    }

    public void delete(int first, int second){
        this.repo.delete(new DecorationsCharacteristics(first, second));
    }

    public List<DecorationsCharacteristics> getAll(){
        return this.repo.getAll();
    }

    public DecorationsCharacteristics find(int first, int second){
        return this.repo.find(first, second);
    }
}
