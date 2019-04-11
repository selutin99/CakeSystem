package com.cake.system.service.cake_order;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.storages.implementations.entities.CakesBasesDB;
import com.cake.system.storages.implementations.entities.CakesDB;
import com.cake.system.storages.implementations.entities.DecorationsDB;

import java.util.HashMap;
import java.util.List;

public class OrderImpl implements Order{

    @Override
    public void acceptOrder(Decorations deco, CakesBases cakesBases) {
        //DECORATIONS
        HashMap<String, List<Decorations>> contextDeco = new HashMap<>();
        DecorationsDB dbDeco = new DecorationsDB();
        ImplUnitOfWork<Decorations> repoDeco = new ImplUnitOfWork(contextDeco, dbDeco);

        repoDeco.create(deco);

        //CAKESBASES
        HashMap<String, List<CakesBases>> contextBases = new HashMap<>();
        CakesBasesDB dbBases = new CakesBasesDB();
        ImplUnitOfWork<CakesBases> repoBases = new ImplUnitOfWork(contextBases, dbBases);

        repoBases.create(cakesBases);

        //CAKES
        HashMap<String, List<Cakes>> contextCake = new HashMap<>();
        CakesDB dbCakes = new CakesDB();
        ImplUnitOfWork<Cakes> repoCakes = new ImplUnitOfWork(contextCake, dbCakes);

        repoBases.create(cakesBases);

    }
}
