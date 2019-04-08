package com.cake.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cakes {
    private int id;
    private String name;
    private float price;

    private int customerID;
    private int cakeBase;
}
