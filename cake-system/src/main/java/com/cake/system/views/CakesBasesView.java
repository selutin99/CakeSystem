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

        int choise = -1;
        do {
            menu();
            System.out.println(":::Введите необходимое действие:::");
            try{
            choise = Integer.parseInt(sc.next());
            }catch(NumberFormatException e){
            }
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
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите название основы торта (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                controller.add(++id, name);
                success = true;
            } catch(IllegalArgumentException e) {
                System.out.println("Введите не пустое название!");
            }
        }
    }

    private void editCakeBase(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите последовательно id и название новой основы торта (для отмены введите -1)");

                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                controller.edit(id, name);
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id и не пустое имя)");
            }
        }
    }

    private void deleteCakeBase(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите последовательно id и название удаляемой основы торта (для отмены введите -1)");

                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                controller.delete(id, name);
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id и не пустое имя)");
            }
        }
    }

    private void findCakeBase(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id искомой основы торта (для отмены введите -1)");

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
