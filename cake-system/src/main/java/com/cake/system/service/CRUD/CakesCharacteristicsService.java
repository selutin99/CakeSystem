package com.cake.system.service.CRUD;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.Connection;

import java.util.List;

public class CakesCharacteristicsService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWorkAssoc<CakesCharacteristics> repo;

    public CakesCharacteristicsService(){
        this.repo = con.getCakesCharRepo();
    }

    public void add(int first, int second){
        this.repo.create(new CakesCharacteristics(first, second));
    }

    public void edit(int first, int second){
        this.repo.edit(new CakesCharacteristics(first, second));
    }

    public void delete(int first, int second){
        this.repo.delete(new CakesCharacteristics(first, second));
    }

    public List<CakesCharacteristics> getAll(){
        return this.repo.getAll();
    }

    public CakesCharacteristics find(int first, int second){
        return this.repo.find(first, second);
    }
}
