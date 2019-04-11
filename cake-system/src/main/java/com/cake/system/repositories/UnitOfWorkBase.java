package com.cake.system.repositories;

public interface UnitOfWorkBase<T> {
    String INSERT = "INSERT";
    String DELETE = "DELETE";
    String EDIT = "EDIT";

    //Создать новую сущность
    void create(T entity);

    //Обновить сущность
    void edit(T entity);

    //Удалить сущность
    void delete(T entity);

    //Внести изменения
    void commit();
}
