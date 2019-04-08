package com.cake.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakesCharacteristics {
    private Cakes cakeID;
    private Characteristics characteristicID;
}
