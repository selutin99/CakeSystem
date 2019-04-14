package com.cake.system.storages.implementations.entities;

import com.cake.system.entity.CakesBases;
import com.cake.system.storages.database.DatabaseEntity;

import java.util.ArrayList;
import java.util.List;

public class CakesBasesDB implements DatabaseEntity<CakesBases> {

    private List<CakesBases> cakesBases;

    public CakesBasesDB() {
        this.cakesBases = new ArrayList<>();
    }

    @Override
    public void insert(CakesBases cakesBases) {
        for(CakesBases ck: this.cakesBases){
            if(ck.getId()==cakesBases.getId()){
                throw new IllegalArgumentException("Элемент с таким id уже существует!");
            }
        }
        this.cakesBases.add(cakesBases);
    }

    @Override
    public void edit(CakesBases cakesBases) {
        int inputID = cakesBases.getId();
        for(int i=0; i<this.cakesBases.size(); i++){
            if(this.cakesBases.get(i).getId()==inputID){

                CakesBases ckb = new CakesBases();
                ckb.setId(cakesBases.getId());
                ckb.setName(cakesBases.getName());

                this.cakesBases.remove(i);
                this.cakesBases.add(i, ckb);

                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public void delete(CakesBases cakesBases) {
        int inputID = cakesBases.getId();
        for(int i=0; i<this.cakesBases.size(); i++){
            if(this.cakesBases.get(i).getId()==inputID){
                this.cakesBases.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public CakesBases findById(int id) {
        for(CakesBases ck: cakesBases){
            if(ck.getId()==id){
                return ck;
            }
        }
        return null;
    }

    @Override
    public List<CakesBases> getAll() {
        return new ArrayList<>(this.cakesBases);
    }
}
