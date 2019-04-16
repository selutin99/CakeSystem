package com.cake.system.storages.database;

public interface DatabaseAssoc<T> extends Database<T> {
    T findById(int firstKey, int secondKey);
}
