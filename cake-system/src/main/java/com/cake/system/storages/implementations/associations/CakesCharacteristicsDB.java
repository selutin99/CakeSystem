package com.cake.system.storages.implementations.associations;

import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.storages.database.DatabaseAssoc;

import java.util.ArrayList;
import java.util.List;

public class CakesCharacteristicsDB implements DatabaseAssoc<CakesCharacteristics> {

    private List<CakesCharacteristics> cakesCharacteristics;

    public CakesCharacteristicsDB() {
        this.cakesCharacteristics = new ArrayList<>();
    }

    @Override
    public void insert(CakesCharacteristics cakesCharacteristics) {
        this.cakesCharacteristics.add(cakesCharacteristics);
    }

    @Override
    public void edit(CakesCharacteristics cakesCharacteristics) {
        int inputCakeID = cakesCharacteristics.getCakeID();

        for (int i = 0; i < this.cakesCharacteristics.size(); i++) {
            if (this.cakesCharacteristics.get(i).getCakeID() == inputCakeID) {

                CakesCharacteristics ck = new CakesCharacteristics();
                ck.setCakeID(cakesCharacteristics.getCakeID());
                ck.setCharacteristicID(cakesCharacteristics.getCharacteristicID());

                this.cakesCharacteristics.remove(i);
                this.cakesCharacteristics.add(i, ck);

                return;
            }
        }
    }

    @Override
    public void delete(CakesCharacteristics cakesCharacteristics) {
        int inputID = cakesCharacteristics.getCakeID();
        int inputCharID = cakesCharacteristics.getCharacteristicID();

        for (int i = 0; i < this.cakesCharacteristics.size(); i++) {
            if (this.cakesCharacteristics.get(i).getCakeID() == inputID &&
                    this.cakesCharacteristics.get(i).getCharacteristicID() == inputCharID) {

                this.cakesCharacteristics.remove(i);
                return;
            }
        }
    }

    @Override
    public CakesCharacteristics findById(int id, int second) {
        for (CakesCharacteristics ck : cakesCharacteristics) {
            if (ck.getCakeID() == id && ck.getCharacteristicID() == second) {
                return ck;
            }
        }
        return null;
    }
}
