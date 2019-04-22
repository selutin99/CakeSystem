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
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите название украшения (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                System.out.println("Введите цену украшения (для отмены введите -1)");
                float price = Float.parseFloat(sc.next());
                if(price==-1){
                    return;
                }
                controller.add(++id, name, price);
                success = true;
            } catch(IllegalArgumentException e) {
                System.out.println("Введите не пустое название и цену!");
            }
        }
    }

    private void editDecorations(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id украшения (для отмены введите -1)");
                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }
                System.out.println("Введите новое название украшения (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                System.out.println("Введите новую цену украшения (для отмены введите -1)");
                float price = Float.parseFloat(sc.next());
                if(price==-1){
                    return;
                }
                controller.edit(id, name, price);
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id и не пустое имя и/или цену)");
            }
        }
    }

    private void deleteDecorations(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id украшения (для отмены введите -1)");
                int id = Integer.parseInt(sc.next());
                if(id==-1){
                    return;
                }
                System.out.println("Введите новое название украшения (для отмены введите -1)");
                String name = sc.next();
                if(name.equals("-1")){
                    return;
                }
                System.out.println("Введите новую цену украшения (для отмены введите -1)");
                float price = Float.parseFloat(sc.next());
                if(price==-1){
                    return;
                }

                controller.delete(id, name, price);
                success = true;
            } catch(NumberFormatException e){
                System.out.println("Введите число верно");
            } catch(IllegalArgumentException e) {
                System.out.println("Введите верное значение (существующий id и не пустое имя и/или цену)");
            }
        }
    }

    private void findDecorations(){
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Введите id искомого украшения (для отмены введите -1)");

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
