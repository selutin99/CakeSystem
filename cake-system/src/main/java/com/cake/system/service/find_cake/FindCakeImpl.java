package com.cake.system.service.find_cake;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;

import java.util.ArrayList;
import java.util.List;

public class FindCakeImpl implements FindCakeService {

    /*Это мой велосипед для autowired.
      Таких велосипедов много, но это мой.
      Мой велосипед - мой лучший друг. Он - моя жизнь.*/

    private ImplUnitOfWork<Cakes> cakesRepo;
    private ImplUnitOfWork<CakesDecorations> cakesDecoRepo;


    public FindCakeImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<CakesDecorations> cakesDecoRepo) {
        this.cakesRepo = cakesRepo;
        this.cakesDecoRepo = cakesDecoRepo;
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
            if(cs.getId()==cakesBasesID){
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
            if(cs.getDecorations()==decoID){
                finalList.add(cakesRepo.find(cs.getCakeID()));
            }
        }
        return finalList;
    }
}
