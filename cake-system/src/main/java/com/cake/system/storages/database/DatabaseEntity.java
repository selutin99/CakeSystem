package com.cake.system.storages.database;

public interface DatabaseEntity<T> extends Database<T> {
    T findById(int id);
}
