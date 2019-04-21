package com.cake.system.views;

import com.cake.system.controllers.*;

import java.util.*;

public class CakeOrderView {
    private static int customerID;
    private static int cakeID;

    private Scanner sc;

    //Controllers
    private CakesController cakes;
    private CustomersController customer;

    private CharacteristicsController characteristics;

    //Associations controllers
    private CakesDecorationsController cakesDecor;
    private CakesCharacteristicsController cakesChar;
    private DecorationsCharacteristicsController decorChar;

    private OrderController orderController;

    public CakeOrderView(Scanner scanner){
        cakes = new CakesController();
        customer = new CustomersController();

        orderController = new OrderController();
        characteristics = new CharacteristicsController();

        cakesDecor = new CakesDecorationsController();
        cakesChar = new CakesCharacteristicsController();
        decorChar = new DecorationsCharacteristicsController();

        orderController = new OrderController();

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
        System.out.println("Клиент успешно добавлен\n");

        System.out.println("Введите название торта");
        String name = sc.next();

        System.out.println("Выберите основу торта");
        int cakeBaseID = addCakeBase();
        System.out.println("Основа успешно добавлена");

        System.out.println("Выберите украшения торта");
        Set<Integer> decorID = addDecor();
        System.out.println("Украшения успешно добавлены");

        System.out.println("Выберите характеристики торта");
        Set<Integer> charID = addCharacteristics();
        System.out.println("Характеристики успешно добавлены");

        Random r = new Random();
        double price = 32.2 + r.nextDouble() * (500.5 - 32.2);

        orderController.addCake(++cakeID, customerID, name, (float)price, cakeBaseID);
        //Для ассоциаций
        for(int i: decorID)
            cakesDecor.add(cakeID, i);
        for(int i: charID)
            cakesChar.add(cakeID, i);

        for(int i: decorID){
            for(int j: charID){
                decorChar.add(i, j);
            }
        }
        System.out.println("\nСкоро будет готов торт: "+cakes.find(cakeID));
    }

    private void addCustomer(){
        System.out.println("Введите имя получателя");
        String name = sc.next();

        System.out.println("Введите фамилию получателя");
        String lastName = sc.next();

        customer.add(++customerID, name, lastName);
    }

    private int addCakeBase(){
        System.out.println("Выберите id основы");
        itera(orderController.getAllBases().iterator());
        return Integer.parseInt(sc.next());
    }

    private Set<Integer> addDecor(){
        Set<Integer> set = new HashSet<>();
        itera(orderController.getAllDecorations().iterator());
        int choise;
        do{
            System.out.println("Выберите id украшений (для выхода введите -1)");
            choise = Integer.parseInt(sc.next());
            if(choise!=-1)
                set.add(choise);
        }while(choise!=-1);
        return set;
    }

    private Set<Integer> addCharacteristics(){
        Set<Integer> set = new HashSet<>();
        itera(orderController.getAllChars().iterator());
        int choise;
        do{
            System.out.println("Выберите id характеристик (для выхода введите -1)");
            choise = Integer.parseInt(sc.next());
            if(choise!=-1)
                set.add(choise);
        }while(choise!=-1);
        return set;
    }

    private void itera(Iterator iterator){
        System.out.println("==============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }
}