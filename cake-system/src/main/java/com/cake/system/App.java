package com.cake.system;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.find_cake.FindCakeImpl;
import com.cake.system.storages.implementations.associations.CakesDecorationsDB;
import com.cake.system.storages.implementations.entities.CakesBasesDB;
import com.cake.system.storages.implementations.entities.CakesDB;
import com.cake.system.storages.implementations.entities.DecorationsDB;

import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //DECORATIONS
        HashMap<String, List<Decorations>> contextDeco = new HashMap<>();
        DecorationsDB dbDeco = new DecorationsDB();
        ImplUnitOfWork<Decorations> repoDeco = new ImplUnitOfWork(contextDeco, dbDeco);
        Decorations deco = new Decorations(1, "Сгущёнка", 33.2F);
        repoDeco.create(deco);

        //CAKE BASES
        HashMap<String, List<CakesBases>> contextBases = new HashMap<>();
        CakesBasesDB dbBase = new CakesBasesDB();
        ImplUnitOfWork<CakesBases> repoBase = new ImplUnitOfWork(contextBases, dbBase);
        CakesBases ckBase = new CakesBases(3, "Вишенка");
        repoBase.create(ckBase);

        //CAKES
        HashMap<String, List<Cakes>> context = new HashMap<>();
        CakesDB db = new CakesDB();
        ImplUnitOfWork<Cakes> repo = new ImplUnitOfWork(context, db);
        Cakes ck = new Cakes(1, "Чизкейк", 33.3F, 1, 3);
        Cakes ck2 = new Cakes(2, "Птичье молоко", 54.3F, 1, 3);
        repo.create(ck);
        repo.create(ck2);

        //CAKES-DECO
        HashMap<String, List<CakesDecorations>> contextCD = new HashMap<>();
        CakesDecorationsDB cdDB = new CakesDecorationsDB();
        ImplUnitOfWorkAssoc<CakesDecorations> cdRepo = new ImplUnitOfWorkAssoc(contextCD, cdDB);
        CakesDecorations cakesDecorations = new CakesDecorations(1, 1);
        cdRepo.create(cakesDecorations);
        cdRepo.create(new CakesDecorations(2, 1));

        FindCakeImpl find = new FindCakeImpl(repo, repoDeco, cdRepo, repoBase);
        System.out.println(find.findCakeByDecoAndBase(1, 3));
    }
}
