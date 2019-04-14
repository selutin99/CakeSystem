package com.cake.system.service.cake_order;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.CheckExist;
import lombok.Setter;

public class OrderImpl implements Order{

    @Setter
    private ImplUnitOfWork<Cakes> cakesRepo;

    @Setter
    private ImplUnitOfWork<Decorations> decoRepo;
    @Setter
    private ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo;

    @Setter
    private ImplUnitOfWork<CakesBases> cakesBasesRepo;

    public OrderImpl(ImplUnitOfWork<Cakes> cakesRepo,
                        ImplUnitOfWork<Decorations> decoRepo,
                        ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo,
                        ImplUnitOfWork<CakesBases> cakesBasesRepo) {
        this.cakesRepo = cakesRepo;
        this.decoRepo = decoRepo;
        this.cakesDecoRepo = cakesDecoRepo;
        this.cakesBasesRepo = cakesBasesRepo;
    }

    @Override
    public void acceptOrder(int cakeID, Decorations deco, CakesBases cakesBases) {
        if(CheckExist.cakeExist(cakesRepo, cakeID)){
            decoRepo.create(deco);
            cakesBasesRepo.create(cakesBases);
            cakesDecoRepo.create(new CakesDecorations(cakeID, deco.getId()));
        }
    }
}
