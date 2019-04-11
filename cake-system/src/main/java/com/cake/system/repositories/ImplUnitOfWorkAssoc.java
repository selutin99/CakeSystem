package com.cake.system.repositories;

import com.cake.system.storages.database.DatabaseAssoc;
import com.cake.system.storages.database.DatabaseEntity;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Log4j2
public class ImplUnitOfWorkAssoc<T> implements UnitOfWorkAssoc<T>{

    //Хранилище действий
    private Map<String, List<T>> context;
    private DatabaseAssoc database;

    public ImplUnitOfWorkAssoc(Map<String, List<T>> context, DatabaseAssoc database){
        this.context = context;
        this.database = database;
    }

    @Override
    public void create(T entity) {
        log.info("Добавление "+entity.toString());
        registerOperation(entity, UnitOfWork.INSERT);
        commit();
    }

    @Override
    public void edit(T entity) {
        log.info("Редактирование "+entity.toString());
        registerOperation(entity, UnitOfWork.EDIT);
        commit();
    }

    @Override
    public void delete(T entity) {
        log.info("Удаление "+entity.toString());
        registerOperation(entity, UnitOfWork.DELETE);
        commit();
    }

    @Override
    public T find(int firstKey, int secondKey) {
        log.info("Поиск с id: "+firstKey+" и "+secondKey);
        return (T) database.findById(firstKey, secondKey);
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
        log.info("Начинаем выполнять транзакцию");
        if(context.containsKey(UnitOfWork.INSERT)){
            commitInsert();
        }
        if(context.containsKey(UnitOfWork.EDIT)){
            commitEdit();
        }
        if(context.containsKey(UnitOfWork.DELETE)){
            commitDelete();
        }
        context.clear();
        log.info("Транзакция завершена");
    }

    private void commitInsert(){
        List<T> entitiesToBeInserted = context.get(UnitOfWork.INSERT);
        for(T t: entitiesToBeInserted){
            log.info("Сохраняем в базу "+t.toString());
            database.insert(t);
        }
    }

    private void commitEdit(){
        List<T> entitiesToBeEdited = context.get(UnitOfWork.EDIT);
        for(T t: entitiesToBeEdited){
            log.info("Редактируем в базе "+t.toString());
            database.edit(t);
        }
    }

    private void commitDelete(){
        List<T> entitiesToBeDeleted = context.get(UnitOfWork.DELETE);
        for(T t: entitiesToBeDeleted){
            log.info("Удаляем из базы "+t.toString());
            database.delete(t);
        }
    }
}
