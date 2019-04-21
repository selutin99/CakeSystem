package com.cake.system.controllers;

import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Characteristics;
import com.cake.system.entity.Decorations;
import com.cake.system.service.cake_order.CakesBasesComponent;
import com.cake.system.service.cake_order.CharacteristicComponent;
import com.cake.system.service.cake_order.DecorationsComponent;
import com.cake.system.service.cake_order.DecoratorCakes;

import java.util.List;

public class OrderController {

    //Украшения
    public void addDecor(int id, String name, float price){
        new DecorationsComponent(id, name, price);
    }

    public List<Decorations> getAllDecorations(){
        DecorationsComponent dd = new DecorationsComponent();
        return dd.getAll();
    }

    //Основы
    public void addBases(int id, String name){
        new CakesBasesComponent(id, name);
    }

    public List<CakesBases> getAllBases(){
        CakesBasesComponent dd = new CakesBasesComponent();
        return dd.getAll();
    }

    //Характеристики
    public void addCharact(int id, String name, String value){
        new CharacteristicComponent(id, name, value);
    }

    public List<Characteristics> getAllChars(){
        CharacteristicComponent dd = new CharacteristicComponent();
        return dd.getAll();
    }

    public void addCake(int id, int customerID, String name, float price, int cakeBase){
        DecoratorCakes dc = new DecoratorCakes();
        dc.addCake(id, customerID, name, price, cakeBase);
    }
}
