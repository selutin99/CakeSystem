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

    public void add(CakesDecorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(CakesDecorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(CakesDecorations data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<CakesDecorations> getAll(){
        return this.repo.getAll();
    }

    public CakesDecorations find(int first, int second){
        return this.repo.find(first, second);
    }
}
