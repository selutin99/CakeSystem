package com.cake.system.views;

import java.util.Scanner;

public class MainMenu {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public MainMenu(){

        header();

        int choise;
        do {
            menu();
            System.out.println(":::Введите необходимое действие:::");
            choise = Integer.parseInt(sc.next());

            switch (choise) {
                case 1:
                    cakeBaseMenu();
                    break;
                case 2:
                    decorationsMenu();
                    break;
                case 3:
                    characteristicsMenu();
                    break;
                case 4:
                    makeOrderMenu();
                    break;
                case 5:
                    System.out.println("Выходим из системы");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введите корректное действие");
            }
        } while(choise!=5);
    }

    public void menu(){
        System.out.println("1 - редактирование основ торта");
        System.out.println("2 - редактирование украшений торта");
        System.out.println("3 - редактирование характеристик торта");
        System.out.println("4 - выдача торта для покупателя");
        System.out.println("5 - выход из системы");
    }

    public void header(){
        System.out.println("Магазин покупки тортов");
        System.out.println("==============================\n");
    }

    private void cakeBaseMenu() {
        CakesBasesView cbv = new CakesBasesView(sc);
    }

    private void decorationsMenu() {
        DecorationsView dv = new DecorationsView(sc);
    }

    private void characteristicsMenu() { CharacteristicsView chv = new CharacteristicsView(sc); }

    private void makeOrderMenu() { CakeOrderView cvv = new CakeOrderView(sc); }
}
