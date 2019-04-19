package com.cake.system.service.CRUD;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.Connection;

import java.util.List;

public class CakesDecorationsService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWorkAssoc<CakesDecorations> repo;

    public CakesDecorationsService(){
        this.repo = con.getCakesDecoRepo();
    }

    public void add(int first, int second){
        this.repo.create(new CakesDecorations(first, second));
    }

    public void edit(int first, int second){
        this.repo.edit(new CakesDecorations(first, second));
    }

    public void delete(int first, int second){
        this.repo.delete(new CakesDecorations(first, second));
    }

    public List<CakesDecorations> getAll(){
        return this.repo.getAll();
    }

    public CakesDecorations find(int first, int second){
        return this.repo.find(first, second);
    }
}
