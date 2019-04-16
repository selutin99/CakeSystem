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

                Customers cs = new Customers();
                cs.setId(customers.getId());
                cs.setFirstName(customers.getFirstName());
                cs.setLastName(customers.getLastName());

                this.customers.remove(i);
                this.customers.add(i, cs);

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

