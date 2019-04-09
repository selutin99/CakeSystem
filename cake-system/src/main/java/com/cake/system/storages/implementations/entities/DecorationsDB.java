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
        this.decorations.add(decorations);
    }

    @Override
    public void edit(Decorations decorations) {
        int inputID = decorations.getId();
        for(int i=0; i<this.decorations.size(); i++){
            if(this.decorations.get(i).getId()==inputID){

                this.decorations.get(i).setPrice(decorations.getId());
                this.decorations.get(i).setName(decorations.getName());
                this.decorations.get(i).setPrice(decorations.getPrice());

                return;
            }
        }
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
}


