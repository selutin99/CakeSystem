package com.cake.system.storages.implementations.entities;


import com.cake.system.entity.Decorations;
import com.cake.system.storages.database.DatabaseEntity;

import java.util.ArrayList;
import java.util.List;

public class DecorationsDB implements DatabaseEntity<Decorations> {

    private List<Decorations> decorations;

    public DecorationsDB() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void insert(Decorations decorations) {
        for(Decorations ck: this.decorations){
            if(ck.getId()==decorations.getId()){
                throw new IllegalArgumentException("Элемент с таким id уже существует!");
            }
        }
        this.decorations.add(decorations);
    }

    @Override
    public void edit(Decorations decorations) {
        int inputID = decorations.getId();
        for(int i=0; i<this.decorations.size(); i++){
            if(this.decorations.get(i).getId()==inputID){

                Decorations dc = new Decorations();
                dc.setId(decorations.getId());
                dc.setName(decorations.getName());
                dc.setPrice(decorations.getPrice());

                this.decorations.remove(i);
                this.decorations.add(i, dc);

                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public void delete(Decorations decorations) {
        int inputID = decorations.getId();
        for(int i=0; i<this.decorations.size(); i++){
            if(this.decorations.get(i).getId()==inputID){
                this.decorations.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public Decorations findById(int id) {
        for(Decorations ck: decorations){
            if(ck.getId()==id){
                return ck;
            }
        }
        return null;
    }

    @Override
    public List<Decorations> getAll() {
        return new ArrayList<>(this.decorations);
    }
}


