package com.cake.system.service;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.repositories.ImplUnitOfWork;

import java.util.List;

public class CheckExist {

    public static boolean cakeExist(ImplUnitOfWork<Cakes> cakesRepo, int cakeID){
        List<Cakes> list = cakesRepo.getAll();
        for(Cakes ck: list){
            if(ck.getId()==cakeID){
                return true;
            }
        }
        return false;
    }

    public static boolean baseExist(ImplUnitOfWork<CakesBases> cakesBasesRepo, int cakeBase){
        List<CakesBases> list = cakesBasesRepo.getAll();
        for(CakesBases ck: list){
            if(ck.getId()==cakeBase){
                return true;
            }
        }
        return false;
    }

    public static boolean decoExist(ImplUnitOfWork<Decorations> decoRepo, int decoID){
        List<Decorations> list = decoRepo.getAll();
        for(Decorations deco: list){
            if(deco.getId()==decoID){
                return true;
            }
        }
        return false;
    }
}
