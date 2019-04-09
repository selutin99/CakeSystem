package com.cake.system.storages.implementations.entities;

import com.cake.system.entity.Customers;
import com.cake.system.storages.database.DatabaseEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomersDB implements DatabaseEntity<Customers> {

    private List<Customers> customers;

    public CustomersDB() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void insert(Customers customers) {
        this.customers.add(customers);
    }

    @Override
    public void edit(Customers customers) {
        int inputID = customers.getId();
        for(int i=0; i<this.customers.size(); i++){
            if(this.customers.get(i).getId()==inputID){

                this.customers.get(i).setId(customers.getId());
                this.customers.get(i).setFirstName(customers.getFirstName());
                this.customers.get(i).setLastName(customers.getLastName());

                return;
            }
        }
    }

    @Override
    public void delete(Customers customers) {
        int inputID = customers.getId();
        for(int i=0; i<this.customers.size(); i++){
            if(this.customers.get(i).getId()==inputID){
                this.customers.remove(i);
                return;
            }
        }
    }

    @Override
    public Customers findById(int id) {
        for(Customers ck: customers){
            if(ck.getId()==id){
                return ck;
            }
        }
        return null;
    }
}

