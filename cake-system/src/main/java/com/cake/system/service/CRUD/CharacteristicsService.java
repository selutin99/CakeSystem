package com.cake.system.service.CRUD;

import com.cake.system.entity.Characteristics;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.service.Connection;

import java.util.List;

public class CharacteristicsService {
    private Connection con = Connection.getInstance();
    private ImplUnitOfWork<Characteristics> repo;

    public CharacteristicsService(){
        this.repo = con.getCharacteristicsRepo();
    }

    public void add(Characteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.create(data);
    }

    public void edit(Characteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.edit(data);
    }

    public void delete(Characteristics data){
        if(data==null){
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
        this.repo.delete(data);
    }

    public List<Characteristics> getAll(){
        return this.repo.getAll();
    }

    public Characteristics find(int id){
        return this.repo.find(id);
    }
}
