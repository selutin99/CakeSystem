package com.cake.system.service.cake_order;

import com.cake.system.entity.Decorations;
import com.cake.system.service.CRUD.DecorationsService;

import java.util.List;

public class DecorationsComponent implements Order {

    private DecorationsService service;

    public DecorationsComponent(){
        service = new DecorationsService();
    }

    public DecorationsComponent(int id, String name, float price) {
        service = new DecorationsService();
        service.add(id, name, price);
    }

    public List<Decorations> getAll(){
        return service.getAll();
    }

    @Override
    public void makeOrder() {
        System.out.println("Добавлено украшение для торта");
    }
}
