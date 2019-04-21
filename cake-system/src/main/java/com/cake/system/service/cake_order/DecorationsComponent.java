package com.cake.system.service.cake_order;

import com.cake.system.service.CRUD.DecorationsService;

public class DecorationsComponent implements Order {

    private DecorationsService service;

    public DecorationsComponent(int id, String name, float price) {
        service = new DecorationsService();
        service.add(id, name, price);
    }

    @Override
    public void makeOrder() {
        System.out.println("Добавлено украшение для торта");
    }
}
