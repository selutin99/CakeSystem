package com.cake.system.repositories;

public interface UnitOfWork<T> extends UnitOfWorkBase<T> {
    //Найти сущность
    T find(int id);
}
