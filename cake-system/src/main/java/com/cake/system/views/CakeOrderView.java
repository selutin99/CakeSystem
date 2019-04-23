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

        int choise = -1;
        do {
            menu();
            System.out.println(":::Введите необходимое действие:::");
            try{
                choise = Integer.parseInt(sc.next());
            }catch(NumberFormatException e){}

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
        String name = "";
        while(true) {
            name = sc.next();
            if(name!=null && !name.trim().isEmpty()){
                break;
            }
            else{
                System.out.println("Введите не пустое название торта");
            }
        }

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
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите имя получателя (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }

                System.out.println("Введите фамилию получателя (для отмены введите -1)");
                String lastName = sc.next();
                if(lastName.equals("-1")){
                    return;
                }

                customer.add(++customerID, name, lastName);
                success = true;
            } catch(IllegalArgumentException e) {
                System.out.println("Введите не пустые значения (фамилию и/или имя)");
            }
        }

    }

    private int addCakeBase(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Выберите id основы");
                itera(orderController.getAllBases().iterator());
                return Integer.parseInt(sc.next());
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id)");
            }
        }
        return 0;
    }

    private Set<Integer> addDecor(){
        Set<Integer> set = new HashSet<>();
        itera(orderController.getAllDecorations().iterator());
        boolean success = false;
        while (!success) {
            try {
                int choise;
                do{
                    System.out.println("Введите последовательно (через клавишу ввода) id украшений");
                    System.out.println("Для окончания выбора введите -1");
                    choise = Integer.parseInt(sc.next());

                    if(choise!=-1)
                        set.add(choise);
                }while(choise!=-1);
                success = true;
            } catch(NumberFormatException e) {
                System.out.println("Введите число!");
            } catch(IllegalArgumentException e){
                System.out.println("Введите допустимое значение!");
            }
        }
        return set;
    }

    private Set<Integer> addCharacteristics(){
        Set<Integer> set = new HashSet<>();
        itera(orderController.getAllChars().iterator());
        boolean success = false;
        while (!success) {
            try {
                int choise;
                do{
                    System.out.println("Введите последовательно (через клавишу ввода) id характеристик");
                    System.out.println("Для окончания выбора введите -1");
                    choise = Integer.parseInt(sc.next());

                    if(choise!=-1)
                        set.add(choise);
                }while(choise!=-1);
                success = true;
            } catch(NumberFormatException e) {
                System.out.println("Введите число!");
            } catch(IllegalArgumentException e){
                System.out.println("Введите допустимое значение!");
            }
        }
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