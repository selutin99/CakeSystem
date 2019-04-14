package com.cake.system.storages.implementations.associations;

import com.cake.system.entity.associations.DecorationsCharacteristics;
import com.cake.system.storages.database.DatabaseAssoc;

import java.util.ArrayList;
import java.util.List;

public class DecorationsCharacteristicsDB implements DatabaseAssoc<DecorationsCharacteristics> {

    private List<DecorationsCharacteristics> decorationsCharacteristics;

    public DecorationsCharacteristicsDB() {
        this.decorationsCharacteristics = new ArrayList<>();
    }

    @Override
    public void insert(DecorationsCharacteristics decorationsCharacteristics) {
        for(DecorationsCharacteristics ck: this.decorationsCharacteristics){
            if(ck.getCakeDecorationID()==decorationsCharacteristics.getCakeDecorationID() &&
                    ck.getCakeDecorationCharacteristicsID()==decorationsCharacteristics.getCakeDecorationCharacteristicsID()){
                throw new IllegalArgumentException("Элемент с таким id уже существует!");
            }
        }
        this.decorationsCharacteristics.add(decorationsCharacteristics);
    }

    @Override
    public void edit(DecorationsCharacteristics decorationsCharacteristics) {
        int inputDecID = decorationsCharacteristics.getCakeDecorationID();
        int inputCharID = decorationsCharacteristics.getCakeDecorationCharacteristicsID();

        for(int i=0; i<this.decorationsCharacteristics.size(); i++){
            if(this.decorationsCharacteristics.get(i).getCakeDecorationID()==inputDecID &&
                    this.decorationsCharacteristics.get(i).getCakeDecorationCharacteristicsID()==inputCharID){

                this.decorationsCharacteristics.get(i).setCakeDecorationID(
                        decorationsCharacteristics.getCakeDecorationID());
                this.decorationsCharacteristics.get(i).setCakeDecorationCharacteristicsID(
                        decorationsCharacteristics.getCakeDecorationCharacteristicsID());
                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public void delete(DecorationsCharacteristics decorationsCharacteristics) {
        int inputDecID = decorationsCharacteristics.getCakeDecorationID();
        int inputCharID = decorationsCharacteristics.getCakeDecorationCharacteristicsID();

        for(int i=0; i<this.decorationsCharacteristics.size(); i++){
            if(this.decorationsCharacteristics.get(i).getCakeDecorationID()==inputDecID){

                DecorationsCharacteristics cd = new DecorationsCharacteristics();
                cd.setCakeDecorationID(decorationsCharacteristics.getCakeDecorationID());
                cd.setCakeDecorationCharacteristicsID(decorationsCharacteristics.getCakeDecorationCharacteristicsID());

                this.decorationsCharacteristics.remove(i);
                this.decorationsCharacteristics.add(i, cd);

                return;
            }
        }
        throw new IllegalArgumentException("Элемента не существует!");
    }

    @Override
    public DecorationsCharacteristics findById(int id, int second) {
        for(DecorationsCharacteristics ck: decorationsCharacteristics){
            if(ck.getCakeDecorationID()==id && ck.getCakeDecorationCharacteristicsID()==second){
                return ck;
            }
        }
        return null;
    }

    @Override
    public List<DecorationsCharacteristics> getAll() {
        return new ArrayList<>(this.decorationsCharacteristics);
    }
}

