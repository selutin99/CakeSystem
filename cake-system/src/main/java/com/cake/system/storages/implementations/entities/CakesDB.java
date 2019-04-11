package com.cake.system.storages.implementations.entities;

import com.cake.system.entity.Cakes;
import com.cake.system.storages.database.DatabaseEntity;

import java.util.ArrayList;
import java.util.List;

public class CakesDB implements DatabaseEntity<Cakes> {

    private List<Cakes> cakes;

    public CakesDB() {
        this.cakes = new ArrayList<>();
    }

    @Override
    public void insert(Cakes cakes) {
        this.cakes.add(cakes);
    }

    @Override
    public void edit(Cakes cakes) {
        int inputID = cakes.getId();
        for(int i=0; i<this.cakes.size(); i++){
            if(this.cakes.get(i).getId()==inputID){

                Cakes cake = new Cakes();
                cake.setId(cakes.getId());
                cake.setName(cakes.getName());
                cake.setPrice(cakes.getPrice());
                cake.setCustomerID(cakes.getCustomerID());
                cake.setCakeBase(cakes.getCakeBase());

                this.cakes.remove(i);
                this.cakes.add(i, cake);

            }
        }
    }

    @Override
    public void delete(Cakes cakes) {
        int inputID = cakes.getId();
        for(int i=0; i<this.cakes.size(); i++){
            if(this.cakes.get(i).getId()==inputID){
                this.cakes.remove(i);
            }
        }
    }

    @Override
    public Cakes findById(int id) {
        for(int i=0; i<this.cakes.size(); i++){
            if(this.cakes.get(i).getId()==id){
                return this.cakes.get(i);
            }
        }
        return null;
    }
}
