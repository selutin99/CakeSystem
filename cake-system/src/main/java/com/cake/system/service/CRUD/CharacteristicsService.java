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

    public void add(int id, String name, String value){
        if(name!=null && !name.trim().isEmpty() && value!=null && !value.trim().isEmpty()){
            this.repo.create(new Characteristics(id, name, value));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void edit(int id, String name, String value){
        if(name!=null && !name.trim().isEmpty() && value!=null && !value.trim().isEmpty()){
            this.repo.edit(new Characteristics(id, name, value));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public void delete(int id, String name, String value){
        if(name!=null && !name.trim().isEmpty() && value!=null && !value.trim().isEmpty()){
            this.repo.delete(new Characteristics(id, name, value));
        }
        else {
            throw new IllegalArgumentException("Нельзя передавать пустой аргумент");
        }
    }

    public List<Characteristics> getAll(){
        return this.repo.getAll();
    }

    public Characteristics find(int id){
        return this.repo.find(id);
    }
}
