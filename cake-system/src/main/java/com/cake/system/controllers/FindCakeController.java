package com.cake.system.controllers;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.service.find_cake.FindCakeImpl;

import java.util.List;

public class FindCakeController {
    private FindCakeImpl service;

    public FindCakeController(){
        this.service = new FindCakeImpl();
    }

    public List<Cakes> findCakeByDecoAndBase(Decorations deco, CakesBases cakesBases){
        return service.findCakeByDecoAndBase(deco.getId(), cakesBases.getId());
    }

    public List<Cakes> findCakeByDecor(Decorations deco){
        return service.findCakeByDecor(deco);
    }

    public List<Cakes> findCakeByBases(CakesBases base){
        return service.findCakeByBases(base);
    }
}
