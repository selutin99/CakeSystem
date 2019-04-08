package com.cake.system.storages;

public interface Database<T> {
    void insert(T t);

    void edit(T t);

    void delete(T t);

    T findById(int id);
}
