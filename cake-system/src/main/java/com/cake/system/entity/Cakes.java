package com.cake.system.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Cakes {
    private int id;
    private String name;
    private float price;

    @NonNull
    private Customers customerID;
    @NonNull
    private CakesBases cakeBase;
}
