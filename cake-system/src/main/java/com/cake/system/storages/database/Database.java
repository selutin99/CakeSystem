package com.cake.system.storages.database;

import java.util.List;

public interface Database<T> {
    void insert(T t);

    void edit(T t);

    void delete(T t);

    List<T> getAll();
}
