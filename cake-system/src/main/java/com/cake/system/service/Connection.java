package com.cake.system.service;

import com.cake.system.entity.*;
import com.cake.system.entity.associations.CakesCharacteristics;
import com.cake.system.entity.associations.CakesDecorations;
import com.cake.system.entity.associations.DecorationsCharacteristics;
import com.cake.system.repositories.ImplUnitOfWork;
import com.cake.system.repositories.ImplUnitOfWorkAssoc;
import com.cake.system.storages.implementations.associations.CakesCharacteristicsDB;
import com.cake.system.storages.implementations.associations.CakesDecorationsDB;
import com.cake.system.storages.implementations.associations.DecorationsCharacteristicsDB;
import com.cake.system.storages.implementations.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

public class Connection {
    private static Connection instance;

    @Getter
    @Setter
    public ImplUnitOfWork<Cakes> cakesRepo;
    @Getter
    @Setter
    public ImplUnitOfWork<CakesBases> cakesBasesRepo;
    @Getter
    @Setter
    public ImplUnitOfWork<Characteristics> characteristicsRepo;
    @Getter
    @Setter
    public ImplUnitOfWork<Customers> customersRepo;
    @Getter
    @Setter
    public ImplUnitOfWork<Decorations> decorationsRepo;

    @Getter
    @Setter
    public ImplUnitOfWorkAssoc<CakesDecorations> cakesDecoRepo;
    @Getter
    @Setter
    public ImplUnitOfWorkAssoc<CakesCharacteristics> cakesCharRepo;
    @Getter
    @Setter
    public ImplUnitOfWorkAssoc<DecorationsCharacteristics> decoCharRepo;

    private Connection(){
        //CAKES
        HashMap<String, List<Cakes>> contextCake = new HashMap<>();
        CakesDB cakesDB = new CakesDB();
        cakesRepo = new ImplUnitOfWork<>(contextCake, cakesDB);

        //CAKES BASES
        HashMap<String, List<CakesBases>> contextCakesBases = new HashMap<>();
        CakesBasesDB cakesBasesDB = new CakesBasesDB();
        cakesBasesRepo = new ImplUnitOfWork<>(contextCakesBases, cakesBasesDB);

        //CHARACTERISTICS
        HashMap<String, List<Characteristics>> contextChar = new HashMap<>();
        CharacteristicsDB charDB = new CharacteristicsDB();
        characteristicsRepo = new ImplUnitOfWork<>(contextChar, charDB);

        //CUSTOMERS
        HashMap<String, List<Customers>> contextCustomers = new HashMap<>();
        CustomersDB custDB = new CustomersDB();
        customersRepo = new ImplUnitOfWork<>(contextCustomers, custDB);

        //DECORATIONS
        HashMap<String, List<Decorations>> contextDeco = new HashMap<>();
        DecorationsDB decoDB = new DecorationsDB();
        decorationsRepo = new ImplUnitOfWork<>(contextDeco, decoDB);

        //CAKES-DECO
        HashMap<String, List<CakesDecorations>> contextCD = new HashMap<>();
        CakesDecorationsDB cdDB = new CakesDecorationsDB();
        cakesDecoRepo = new ImplUnitOfWorkAssoc(contextCD, cdDB);

        //CAKES-CHAR
        HashMap<String, List<CakesCharacteristics>> contextCC = new HashMap<>();
        CakesCharacteristicsDB ccDB = new CakesCharacteristicsDB();
        cakesCharRepo = new ImplUnitOfWorkAssoc(contextCC, ccDB);

        //DECO-CHAR
        HashMap<String, List<DecorationsCharacteristics>> contextDC = new HashMap<>();
        DecorationsCharacteristicsDB dcDB = new DecorationsCharacteristicsDB();
        decoCharRepo = new ImplUnitOfWorkAssoc(contextDC, dcDB);
    }

    public static synchronized Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }
}
