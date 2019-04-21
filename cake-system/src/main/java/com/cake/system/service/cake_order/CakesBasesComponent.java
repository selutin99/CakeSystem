package com.cake.system.service.cake_order;

import com.cake.system.entity.CakesBases;
import com.cake.system.service.CRUD.CakesBasesService;

import java.util.List;

public class CakesBasesComponent implements Order{

    private CakesBasesService service;

    public CakesBasesComponent(){
        service = new CakesBasesService();
    }

    public CakesBasesComponent(int id, String name){
        service = new CakesBasesService();
        service.add(id, name);
    }

    public List<CakesBases> getAll(){
        return service.getAll();
    }

    @Override
    public void makeOrder() {
        System.out.println("Добавлена основа торта");
    }
}
