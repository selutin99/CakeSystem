package com.cake.system.service.find_cake;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;

import java.util.ArrayList;
import java.util.List;

public class FindCakeImpl implements FindCakeService {

    /*Это мой велосипед autowired.
      Таких велосипедов много, но это мой.
      Мой велосипед - мой лучший друг. Он - моя жизнь.*/

    private ImplUnitOfWork<Cakes> cakesRepo;

    private ImplUnitOfWork<Decorations> decoRepo;
    private ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo;

    private ImplUnitOfWork<CakesBases> cakesBasesRepo;

    public FindCakeImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<Decorations> decoRepo,
                        ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo,
                        ImplUnitOfWork<CakesBases> cakesBasesRepo) {
        this.cakesRepo = cakesRepo;
        this.decoRepo = decoRepo;
        this.cakesDecoRepo = cakesDecoRepo;
        this.cakesBasesRepo = cakesBasesRepo;
    }

    public FindCakeImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<Decorations> decoRepo,
                        ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo) {
        this.cakesRepo = cakesRepo;
        this.decoRepo = decoRepo;
        this.cakesDecoRepo = cakesDecoRepo;
    }

    public FindCakeImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<CakesBases> cakesBasesRepo) {
        this.cakesRepo = cakesRepo;
        this.cakesBasesRepo = cakesBasesRepo;
    }

    @Override
    public List<Cakes> findCakeByBases(CakesBases cakesBases) {
        return findCakeByBases(cakesBases.getId());
    }

    @Override
    public List<Cakes> findCakeByBases(int cakesBasesID) {
        List<Cakes> finalList = new ArrayList<>();

        List<Cakes> cakes = cakesRepo.getAll();
        for(Cakes cs: cakes){
            if(cs.getCakeBase()==cakesBasesID && baseExist(cakesBasesRepo, cakesBasesID)){
                finalList.add(cs);
            }
        }
        return finalList;
    }

    @Override
    public List<Cakes> findCakeByDecor(Decorations deco) {
        return findCakeByDecor(deco.getId());
    }

    @Override
    public List<Cakes> findCakeByDecor(int decoID) {
        List<Cakes> finalList = new ArrayList<>();

        List<CakesDecorations> cakesDeco = cakesDecoRepo.getAll();
        for(CakesDecorations cs: cakesDeco){
            if(cs.getDecorations()==decoID && decoExist(decoRepo, decoID)){
                finalList.add(cakesRepo.find(cs.getCakeID()));
            }
        }
        return finalList;
    }

    private boolean baseExist(ImplUnitOfWork<CakesBases> cakesBasesRepo, int cakeBase){
        List<CakesBases> list = cakesBasesRepo.getAll();
        for(CakesBases ck: list){
            if(ck.getId()==cakeBase){
                return true;
            }
        }
        return false;
    }

    private boolean decoExist(ImplUnitOfWork<Decorations> decoRepo, int decoID){
        List<Decorations> list = decoRepo.getAll();
        for(Decorations deco: list){
            if(deco.getId()==decoID){
                return true;
            }
        }
        return false;
    }
}
