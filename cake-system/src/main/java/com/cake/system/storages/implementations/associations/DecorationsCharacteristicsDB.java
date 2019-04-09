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
    }

    @Override
    public void delete(DecorationsCharacteristics decorationsCharacteristics) {
        int inputDecID = decorationsCharacteristics.getCakeDecorationID();
        int inputCharID = decorationsCharacteristics.getCakeDecorationCharacteristicsID();

        for(int i=0; i<this.decorationsCharacteristics.size(); i++){
            if(this.decorationsCharacteristics.get(i).getCakeDecorationID()==inputDecID &&
                    this.decorationsCharacteristics.get(i).getCakeDecorationCharacteristicsID()==inputCharID){

                this.decorationsCharacteristics.remove(i);
                return;
            }
        }
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
}

