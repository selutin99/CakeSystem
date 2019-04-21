package com.cake.system.views;

import com.cake.system.controllers.CharacteristicsController;

import java.util.Iterator;
import java.util.Scanner;

public class CharacteristicsView {
    private static int id;

    private CharacteristicsController controller;
    private Scanner sc;

    public CharacteristicsView(Scanner scanner){
        this.controller = new CharacteristicsController();
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
                    addCharacteristics();
                    break;
                case 2:
                    editCharacteristics();
                    break;
                case 3:
                    deleteCharacteristics();
                    break;
                case 4:
                    findCharacteristics();
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
        System.out.println("Редактирование характеристик торта");
        System.out.println("==============================\n");
    }

    private void menu(){
        System.out.println("1 - добавление характеристик торта");
        System.out.println("2 - редактирование характеристик торта");
        System.out.println("3 - удаление характеристик торта");
        System.out.println("4 - поиск характеристик по id");
        System.out.println("5 - информация обо всех характеристиках тортов");

        System.out.println("0 - в главное меню\n");
    }

    private void addCharacteristics(){
        System.out.println("Введите название характеристики");
        String name = sc.next();
        System.out.println("Введите значение характеристики");
        String value = sc.next();

        controller.add(++id, name, value);
    }

    private void editCharacteristics(){
        System.out.println("Введите id украшения");
        int id = Integer.parseInt(sc.next());

        System.out.println("Введите новую характеристику");
        String name = sc.next();

        System.out.println("Введите новое значение характеристики");
        String value = sc.next();

        controller.edit(id, name, value);
    }

    private void deleteCharacteristics(){
        System.out.println("Введите id характеристики");
        int id = Integer.parseInt(sc.next());

        System.out.println("Введите удаляемое название характеристики");
        String name = sc.next();

        System.out.println("Введите удаляемое значение характеристики");
        String value = sc.next();

        controller.delete(id, name, value);
    }

    private void findCharacteristics(){
        System.out.println("Введите id искомой характеристики");

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
