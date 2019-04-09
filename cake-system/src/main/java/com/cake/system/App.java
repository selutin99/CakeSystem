package com.cake.system;

import com.cake.system.entity.Cakes;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.storages.implementations.entities.CakesDB;

import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Cakes pm = new Cakes(1, "Птичье молоко", 33.03F, 1, 2);

        HashMap<String, List<Cakes>> context = new HashMap<>();
        CakesDB cakesDB = new CakesDB();
        ImplUnitOfWork<Cakes> cakesRepo = new ImplUnitOfWork<>(context, cakesDB);

        cakesRepo.create(pm);
        cakesRepo.commit();

        System.out.println(cakesRepo.find(1));
    }
}
