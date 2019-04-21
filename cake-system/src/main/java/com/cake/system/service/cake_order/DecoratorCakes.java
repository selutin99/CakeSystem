package com.cake.system.service.cake_order;

import com.cake.system.service.CRUD.CakesService;

public class DecoratorCakes extends Decorator {
    private CakesService service;

    public DecoratorCakes(Order order){
        super(order);
        service = new CakesService();
    }

    public void addCake(int id, int customerID, String name, float price, int cakeBase){
        service.add(id, customerID, name, price, cakeBase);
    }
}
