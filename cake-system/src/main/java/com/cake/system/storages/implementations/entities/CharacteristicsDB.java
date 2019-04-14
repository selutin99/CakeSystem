package com.cake.system.storages.implementations.entities;

import com.cake.system.entity.Characteristics;
import com.cake.system.storages.database.DatabaseEntity;

import java.util.ArrayList;
import java.util.List;

public class CharacteristicsDB implements DatabaseEntity<Characteristics> {

    private List<Characteristics> characteristics;

    public CharacteristicsDB() {
        this.characteristics = new ArrayList<>();
    }

    @Override
    public void insert(Characteristics characteristics) {
        for(Characteristics ck: this.characteristics){
            if(ck.getId()==characteristics.getId()){
                throw new IllegalArgumentException("Элемент с таким id уже существует!");
            }
        }
        this.characteristics.add(characteristics);
    }

    @Override
    public void edit(Characteristics characteristics) {
        int inputID = characteristics.getId();
        for(int i=0; i<this.characteristics.size(); i++){
            if(this.characteristics.get(i).getId()==inputID){

                Characteristics ch = new Characteristics();
                ch.setId(characteristics.getId());
                ch.setName(characteristics.getName());
                ch.setValue(characteristics.getValue());

                this.characteristics.remove(i);
                this.characteristics.add(i, ch);

                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public void delete(Characteristics characteristics) {
        int inputID = characteristics.getId();
        for(int i=0; i<this.characteristics.size(); i++){
            if(this.characteristics.get(i).getId()==inputID){
                this.characteristics.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public Characteristics findById(int id) {
        for(Characteristics ck: characteristics){
            if(ck.getId()==id){
                return ck;
            }
        }
        return null;
    }

    @Override
    public List<Characteristics> getAll() {
        return new ArrayList<>(this.characteristics);
    }
}
