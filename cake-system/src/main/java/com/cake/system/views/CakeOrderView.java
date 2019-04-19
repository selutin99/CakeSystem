package com.cake.system.views;

import com.cake.system.controllers.DecorationsController;

import java.util.Iterator;
import java.util.Scanner;

public class CakeOrderView {
    private static int id;


    private Scanner sc;

    public CakeOrderView(Scanner scanner){

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

    }

}
