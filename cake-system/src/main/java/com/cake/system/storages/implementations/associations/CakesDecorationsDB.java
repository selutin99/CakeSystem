package com.cake.system.storages.implementations.associations;

import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.storages.database.DatabaseAssoc;

import java.util.ArrayList;
import java.util.List;

public class CakesDecorationsDB implements DatabaseAssoc<CakesDecorations> {

    private List<CakesDecorations> cakesDecorations;

    public CakesDecorationsDB() {
        this.cakesDecorations = new ArrayList<>();
    }

    @Override
    public void insert(CakesDecorations cakesDecorations) {
        this.cakesDecorations.add(cakesDecorations);
    }

    @Override
    public void edit(CakesDecorations cakesDecorations) {
        int inputCakeID = cakesDecorations.getCakeID();
        int inputDecID = cakesDecorations.getDecorations();

        for(int i=0; i<this.cakesDecorations.size(); i++){
            if(this.cakesDecorations.get(i).getCakeID()==inputCakeID &&
                    this.cakesDecorations.get(i).getDecorations()==inputDecID){

                this.cakesDecorations.get(i).setCakeID(cakesDecorations.getCakeID());
                this.cakesDecorations.get(i).setDecorations(cakesDecorations.getDecorations());

                return;
            }
        }
    }

    @Override
    public void delete(CakesDecorations cakesDecorations) {
        int inputCakeID = cakesDecorations.getCakeID();
        int inputDecID = cakesDecorations.getDecorations();

        for(int i=0; i<this.cakesDecorations.size(); i++){
            if(this.cakesDecorations.get(i).getCakeID()==inputCakeID &&
                    this.cakesDecorations.get(i).getDecorations()==inputDecID){

                this.cakesDecorations.remove(i);
                return;
            }
        }
    }

    @Override
    public CakesDecorations findById(int id, int second) {
        for(CakesDecorations ck: cakesDecorations){
            if(ck.getCakeID()==id && ck.getDecorations()==second){
                return ck;
            }
        }
        return null;
    }
}

