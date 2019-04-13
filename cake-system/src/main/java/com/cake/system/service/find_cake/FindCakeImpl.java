package com.cake.system.service.find_cake;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;

import java.util.ArrayList;
import java.util.List;

public class FindCakeImpl implements FindCakeService {

    /*Это мой велосипед autowired.
      Таких велосипедов много, но это мой.
      Мой велосипед - мой лучший друг. Он - моя жизнь.*/

    private ImplUnitOfWork<Cakes> cakesRepo;

    private ImplUnitOfWork<Decorations> decoRepo;
    private ImplUnitOfWork<CakesDecorations> cakesDecoRepo;

    private ImplUnitOfWork<CakesBases> cakesBasesRepo;

    public FindCakeImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<Decorations> decoRepo,
                        ImplUnitOfWork<CakesDecorations> cakesDecoRepo,
                        ImplUnitOfWork<CakesBases> cakesBasesRepo) {
        this.cakesRepo = cakesRepo;
        this.decoRepo = decoRepo;
        this.cakesDecoRepo = cakesDecoRepo;
        this.cakesBasesRepo = cakesBasesRepo;
    }

    public FindCakeImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<Decorations> decoRepo,
                        ImplUnitOfWork<CakesDecorations> cakesDecoRepo) {
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


    public boolean <T> baseExists(int id){
        List<CakesBases> baseList = cakesBasesRepo.getAll();
        for(CakesBases cb: baseList){

        }
    }
}
