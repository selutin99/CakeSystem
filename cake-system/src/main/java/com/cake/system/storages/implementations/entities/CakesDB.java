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

                this.cakes.get(i).setId(cakes.getId());
                this.cakes.get(i).setName(cakes.getName());
                this.cakes.get(i).setPrice(cakes.getPrice());
                this.cakes.get(i).setCustomerID(cakes.getCustomerID());
                this.cakes.get(i).setCakeBase(cakes.getCakeBase());

                return;
            }
        }
    }

    @Override
    public void delete(Cakes cakes) {
        int inputID = cakes.getId();
        for(int i=0; i<this.cakes.size(); i++){
            if(this.cakes.get(i).getId()==inputID){
                this.cakes.remove(i);
                return;
            }
        }
    }

    @Override
    public Cakes findById(int id) {
        for(Cakes ck: cakes){
            if(ck.getId()==id){
                return ck;
            }
        }
        return null;
    }
}
