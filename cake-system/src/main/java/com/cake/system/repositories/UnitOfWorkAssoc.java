package com.cake.system.repositories;

public interface UnitOfWorkAssoc<T> extends UnitOfWorkBase<T> {
    //Найти сущность
    T find(int firstKey, int secondKey);
}
