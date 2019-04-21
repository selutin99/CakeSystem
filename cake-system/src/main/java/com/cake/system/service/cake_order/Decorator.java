package com.cake.system.service.cake_order;

public abstract class Decorator implements Order {
    protected Order order;

    public Decorator(Order order){
        this.order = order;
    }

    @Override
    public void makeOrder(){
        order.makeOrder();
    }
}
