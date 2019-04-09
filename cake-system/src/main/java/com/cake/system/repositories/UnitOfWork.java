package com.cake.system.repositories;

import java.util.List;

public interface UnitOfWork<T> {
    String INSERT = "INSERT";
    String DELETE = "DELETE";
    String EDIT = "EDIT";

    //Создать новую сущность
    void create(T entity);

    //Обновить сущность
    void edit(T entity);

    //Удалить сущность
    void delete(T entity);

    //Найти сущность
    T find(int id);

    //Внести изменения
    void commit();
}
