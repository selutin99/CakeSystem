package com.cake.system.views;

import com.cake.system.controllers.DecorationsController;

import java.util.Iterator;
import java.util.Scanner;

public class DecorationsView {
    private static int id;

    private DecorationsController controller;
    private Scanner sc;

    public DecorationsView(Scanner scanner){
        this.controller = new DecorationsController();
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
                    addDecoration();
                    break;
                case 2:
                    editDecorations();
                    break;
                case 3:
                    deleteDecorations();
                    break;
                case 4:
                    findDecorations();
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
        System.out.println("Редактирование украшений для торта");
        System.out.println("==============================\n");
    }

    private void menu(){
        System.out.println("1 - добавление украшений торта");
        System.out.println("2 - редактирование украшений торта");
        System.out.println("3 - удаление украшений для торта");
        System.out.println("4 - поиск украшений по id");
        System.out.println("5 - информация обо всех украшениях для тортов");

        System.out.println("0 - в главное меню\n");
    }

    private void addDecoration(){
        System.out.println("Введите название украшения");
        String name = sc.next();
        System.out.println("Введите цену украшения");
        float price = Float.parseFloat(sc.next());

        controller.add(++id, name, price);
    }

    private void editDecorations(){
        System.out.println("Введите id украшения");
        int id = Integer.parseInt(sc.next());

        System.out.println("Введите новое название украшения");
        String name = sc.next();

        System.out.println("Введите новую цену украшения");
        float price = Float.parseFloat(sc.next());

        controller.edit(id, name, price);
    }

    private void deleteDecorations(){
        System.out.println("Введите id украшения");
        int id = Integer.parseInt(sc.next());

        System.out.println("Введите удаляемое название украшения");
        String name = sc.next();

        System.out.println("Введите удаляемую цену украшения");
        float price = Float.parseFloat(sc.next());

        controller.delete(id, name, price);
    }

    private void findDecorations(){
        System.out.println("Введите id искомого украшения");

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
