package com.cake.system.service.cake_order;

import com.cake.system.entity.Characteristics;
import com.cake.system.service.CRUD.CharacteristicsService;

import java.util.List;

public class CharacteristicComponent implements Order{

    private CharacteristicsService service;

    public CharacteristicComponent(){
        service = new CharacteristicsService();
    }

    public CharacteristicComponent(int id, String name, String value){
        service = new CharacteristicsService();
        service.add(id, name, value);
    }

    public List<Characteristics> getAll(){
        return service.getAll();
    }

    @Override
    public void makeOrder() {
        System.out.println("Добавлена характеристика");
    }
}
