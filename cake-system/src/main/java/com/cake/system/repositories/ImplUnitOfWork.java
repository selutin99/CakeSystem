package com.cake.system.repositories;

import com.cake.system.storages.Database;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Log4j2
public class ImplUnitOfWork<T> implements UnitOfWork<T>{

    //Хранилище действий
    private Map<String, List<T>> context;
    private Database database;

    public ImplUnitOfWork(Map<String, List<T>> context, Database database){
        this.context = context;
        this.database = database;
    }

    @Override
    public void create(T entity) {
        log.info("Добавление "+entity.toString());
        registerOperation(entity, UnitOfWork.INSERT);
    }

    @Override
    public void edit(T entity) {
        log.info("Редактирование "+entity.toString());
        registerOperation(entity, UnitOfWork.EDIT);
    }

    @Override
    public void delete(T entity) {
        log.info("Удаление "+entity.toString());
        registerOperation(entity, UnitOfWork.DELETE);
    }

    @Override
    public T find(int id) {
        return (T) database.findById(id);
    }

    private void registerOperation(T entity, String operation){
        List<T> entityToOperate = context.get(operation);
        if(entityToOperate == null){
            entityToOperate = new ArrayList<>();
        }
        entityToOperate.add(entity);
        context.put(operation, entityToOperate);
    }

    @Override
    public void commit() {
        if(context == null || context.size() == 0){
            return;
        }
        log.info("Начинаем выполнять действия");
        if(context.containsKey(UnitOfWork.INSERT)){
            commitInsert();
        }
        if(context.containsKey(UnitOfWork.EDIT)){
            commitEdit();
        }
        if(context.containsKey(UnitOfWork.DELETE)){
            commitDelete();
        }
        log.info("Выполнение действий завершено");
    }

    private void commitInsert(){
        List<T> entitiesToBeInserted = context.get(UnitOfWork.INSERT);
        for(T t: entitiesToBeInserted){
            log.info("Сохраняем в базу "+t.toString());
            database.insert(t);
        }
    }

    private void commitEdit(){
        List<T> entitiesToBeInserted = context.get(UnitOfWork.INSERT);
        for(T t: entitiesToBeInserted){
            log.info("Редактируем в базе "+t.toString());
            database.edit(t);
        }
    }

    private void commitDelete(){
        List<T> entitiesToBeInserted = context.get(UnitOfWork.INSERT);
        for(T t: entitiesToBeInserted){
            log.info("Удаляем из базы "+t.toString());
            database.delete(t);
        }
    }
}
