package com.cake.system.storages.database;

public interface Database<T> {
    void insert(T t);

    void edit(T t);

    void delete(T t);
}
