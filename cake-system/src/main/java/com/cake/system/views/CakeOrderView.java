package com.cake.system.views;

import com.cake.system.controllers.*;
import com.cake.system.entity.CakesBases;

import java.util.Scanner;

public class CakeOrderView {
    private static int id;

    private Scanner sc;

    //Controllers
    private CakesController cakes;
    private CustomersController customer;

    //Associations controllers
    private CakesDecorationsController cakesDecor;
    private CakesCharacteristicsController cakesChar;
    private DecorationsCharacteristicsController decorChar;

    private CakesBasesController cakesBases;

    public CakeOrderView(Scanner scanner){
        cakes = new CakesController();
        customer = new CustomersController();

        cakesDecor = new CakesDecorationsController();
        cakesChar = new CakesCharacteristicsController();
        decorChar = new DecorationsCharacteristicsController();

        cakesBases = new CakesBasesController();

        sc = scanner;

        header();

        int choise;
        do {
            menu();
            System.out.println(":::Введите необходимое действие:::");
            choise = Integer.parseInt(sc.next());

            switch (choise) {
                case 0:
                    break;
                case 1:
                    makeOrder();
                    break;
                default:
                    System.out.println("Введите корректное действие");
            }
        } while(choise!=0);
        new MainMenu();
    }

    private void header(){
        System.out.println("Выдача торта");
        System.out.println("==============================\n");
    }

    private void menu(){
        System.out.println("1 - оформить заказ");
        System.out.println("0 - в главное меню\n");
    }

    private void makeOrder() {
        System.out.println("Добавляем клиента");
        addCustomer();
        System.out.println("Клиент успешно добавлен");
        System.out.println();
    }

    private void addCustomer(){
        System.out.println("Введите имя получателя");
        String name = sc.next();

        System.out.println("Введите фамилию получателя");
        String lastName = sc.next();

        customer.add(++id, name, lastName);
    }
}
