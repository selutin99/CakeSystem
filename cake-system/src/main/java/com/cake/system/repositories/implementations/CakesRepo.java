package com.cake.system.repositories.implementations;

import com.cake.system.entity.Cakes;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.storages.Database;

import java.util.List;
import java.util.Map;

public class CakesRepo extends ImplUnitOfWork<Cakes> {
    public CakesRepo(Map<String, List<Cakes>> context, Database database) {
        super(context, database);
    }
}
