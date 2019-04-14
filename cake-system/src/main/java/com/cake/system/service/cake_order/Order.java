package com.cake.system.service.cake_order;

import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;

public interface Order {
    //Принимает заказ
    void acceptOrder(int cakeID, Decorations decorations, CakesBases cakesBases);
}
