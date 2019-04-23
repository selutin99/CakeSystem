package com.cake.system.service.cake_order;

import com.cake.system.entity.Cakes;
import com.cake.system.service.CRUD.CakesService;

import java.util.List;

public class DecoratorCakes extends Decorator {
    private CakesService service;

    public DecoratorCakes(){
        service = new CakesService();
    }

    public List<Cakes> getAll(){
        return service.getAll();
    }

    public void addCake(int id, int customerID, String name, float price, int cakeBase){
        service.add(id, customerID, name, price, cakeBase);
    }
}
