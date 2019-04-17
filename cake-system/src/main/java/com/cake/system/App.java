package com.cake.system;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.service.Connection;
import com.cake.system.service.find_cake.FindCakeImpl;
import com.cake.system.storages.implementations.associations.CakesDecorationsDB;
import com.cake.system.storages.implementations.entities.CakesBasesDB;
import com.cake.system.storages.implementations.entities.CakesDB;
import com.cake.system.storages.implementations.entities.DecorationsDB;

import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Connection con = Connection.getInstance();

        ImplUnitOfWork<Cakes> repo = con.getCakesRepo();
        Cakes ck = new Cakes(1, "Чизкейк", 33.3F, 1, 1);
        Cakes ck2 = new Cakes(2, "Птичье молоко", 54.3F, 1, 1);
        repo.create(ck);
        repo.create(ck2);

        ImplUnitOfWork<CakesBases> basesRepo = con.getCakesBasesRepo();
        basesRepo.create(new CakesBases(1, "Вишенка"));

        FindCakeImpl find = new FindCakeImpl();
        System.out.println(find.findCakeByBases(1));
    }
}
