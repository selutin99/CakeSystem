package com.cake.system;

import com.cake.system.entity.Cakes;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.storages.implementations.entities.CakesDB;

import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        HashMap<String, List<Cakes>> context = new HashMap<>();
        CakesDB db = new CakesDB();
        ImplUnitOfWork<Cakes> repo = new ImplUnitOfWork(context, db);

        Cakes ck = new Cakes(1,"Чизкейк",33.3F,1,2);

        repo.create(ck);

        repo.edit(new Cakes(1,"Медовик", 44.4F, 2, 3));

        repo.delete(repo.find(1));

        System.out.println(repo.find(1));
    }
}
