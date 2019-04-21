package com.cake.system.service.cake_order;

import com.cake.system.service.CRUD.CakesBasesService;

public class CakesBasesComponent implements Order{

    private CakesBasesService service;

    public CakesBasesComponent(int id, String name){
        service = new CakesBasesService();
        service.add(id, name);
    }

    @Override
    public void makeOrder() {
        System.out.println("Добавлена основа торта");
    }
}
