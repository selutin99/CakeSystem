package com.cake.system.service.cake_order;

public abstract class Decorator implements Order {
    @Override
    public void makeOrder(){
        System.out.println("Заказ выполнен");
    }
}
