package com.cake.system.views;

import com.cake.system.controllers.CakesBasesController;

import java.util.Iterator;
import java.util.Scanner;

public class CakesBasesView {
    private static int id;

    private CakesBasesController controller;
    private Scanner sc;

    public CakesBasesView(Scanner scanner){
        this.controller = new CakesBasesController();
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
                    addCakeBase();
                    break;
                case 2:
                    editCakeBase();
                    break;
                case 3:
                    deleteCakeBase();
                    break;
                case 4:
                    findCakeBase();
                    break;
                case 5:
                    getAll();
                    break;
                default:
                    System.out.println("Введите корректное действие");
            }
        } while(choise!=0);
        new MainMenu();
    }

    private void header(){
        System.out.println("Редактирование основ для торта");
        System.out.println("==============================\n");
    }

    private void menu(){
        System.out.println("1 - добавление основ торта");
        System.out.println("2 - редактирование основ торта");
        System.out.println("3 - удаление основ для торта");
        System.out.println("4 - поиск основ торта по id");
        System.out.println("5 - информация обо всех основах для тортов");

        System.out.println("0 - в главное меню\n");
    }

    private void addCakeBase(){
        System.out.println("Введите название основы торта");
        String name = sc.next();
        controller.add(++id, name);
    }

    private void editCakeBase(){
        System.out.println("Введите последовательно id и название новой основы торта");

        int id = Integer.parseInt(sc.next());
        String name = sc.next();

        controller.edit(id, name);
    }

    private void deleteCakeBase(){
        System.out.println("Введите последовательно id и название удаляемой основы торта");

        int id = Integer.parseInt(sc.next());
        String name = sc.next();

        controller.delete(id, name);
    }

    private void findCakeBase(){
        System.out.println("Введите id искомой основы торта");

        int id = Integer.parseInt(sc.next());
        System.out.println(controller.find(id)+"\n");
    }

    private void getAll(){
        Iterator iterator = controller.getAll().iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }
}
