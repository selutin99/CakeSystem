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
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите название характеристики (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                System.out.println("Введите значение характеристики (для отмены введите -1)");
                String value = sc.next();
                if(value.equals("-1")){
                    return;
                }
                controller.add(++id, name, value);
                success = true;
            } catch(IllegalArgumentException e) {
                System.out.println("Введите не пустое название и значение!");
            }
        }
    }

    private void editCharacteristics(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id характеристики (для отмены введите -1)");
                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }

                System.out.println("Введите новую характеристику (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }

                System.out.println("Введите новое значение характеристики (для отмены введите -1)");
                String value = sc.next();
                if(value.equals("-1")){
                    return;
                }
                controller.edit(id, name, value);
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id и не пустое имя и/или значение)");
            }
        }
    }

    private void deleteCharacteristics(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id характеристики (для отмены введите -1)");
                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }

                System.out.println("Введите удаляемое название характеристики (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }

                System.out.println("Введите удаляемое значение характеристики (для отмены введите -1)");
                String value = sc.next();
                if(value.equals("-1")){
                    return;
                }
                controller.delete(id, name, value);
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id и не пустое имя и/или значение)");
            }
        }
    }

    private void findCharacteristics(){

        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id искомой характеристики (для отмены введите -1)");

                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }
                System.out.println(controller.find(id)+"\n");
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id)");
            }
        }
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
