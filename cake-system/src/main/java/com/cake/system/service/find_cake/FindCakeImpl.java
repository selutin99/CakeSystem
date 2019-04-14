package com.cake.system.service.find_cake;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.CheckExist;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class FindCakeImpl implements FindCakeService {

    /*Это мой велосипед autowired.
      Таких велосипедов много, но это мой.
      Мой велосипед - мой лучший друг. Он - моя жизнь.*/
    @Setter
    private ImplUnitOfWork<Cakes> cakesRepo;

    @Setter
    private ImplUnitOfWork<Decorations> decoRepo;
    @Setter
    private ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo;

    @Setter
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
        if(cakesRepo==null || cakesBasesRepo==null){
            throw new IllegalArgumentException("Нужно передать хранилище!");
        }
        List<Cakes> finalList = new ArrayList<>();

        List<Cakes> cakes = cakesRepo.getAll();
        for(Cakes cs: cakes){
            if(cs.getCakeBase()==cakesBasesID && CheckExist.baseExist(cakesBasesRepo, cakesBasesID)){
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
        if(cakesRepo==null || cakesDecoRepo==null || decoRepo==null){
            throw new IllegalArgumentException("Нужно передать хранилище!");
        }
        List<Cakes> finalList = new ArrayList<>();

        List<CakesDecorations> cakesDeco = cakesDecoRepo.getAll();
        for(CakesDecorations cs: cakesDeco){
            if(cs.getDecorations()==decoID && CheckExist.decoExist(decoRepo, decoID)){
                finalList.add(cakesRepo.find(cs.getCakeID()));
            }
        }
        return finalList;
    }

    @Override
    public List<Cakes> findCakeByDecoAndBase(Decorations deco, CakesBases cakesBases) {
        return findCakeByDecoAndBase(deco.getId(), cakesBases.getId());
    }

    @Override
    public List<Cakes> findCakeByDecoAndBase(int decoID, int cakesBasesID) {
        if(cakesRepo==null || cakesDecoRepo==null || decoRepo==null || cakesBasesRepo==null){
            throw new IllegalArgumentException("Нужно передать хранилище!");
        }

        List<Cakes> finalList = new ArrayList<>();
        List<Cakes> neccessaryCakes = new ArrayList<>();
        List<CakesDecorations> cakesDeco = cakesDecoRepo.getAll();

        for(CakesDecorations cs: cakesDeco){
            if(cs.getDecorations()==decoID && CheckExist.decoExist(decoRepo, decoID)){
                neccessaryCakes.add(cakesRepo.find(cs.getCakeID()));
            }
        }

        for(Cakes cs: neccessaryCakes){
            if(cs.getCakeBase()==cakesBasesID && CheckExist.baseExist(cakesBasesRepo, cakesBasesID)){
                finalList.add(cs);
            }
        }
        return finalList;
    }


}
