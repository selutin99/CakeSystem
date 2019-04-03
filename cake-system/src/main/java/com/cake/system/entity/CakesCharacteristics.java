package com.cake.system.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class CakesCharacteristics {
    @NonNull
    private Cakes cakeID;

    @NonNull
    private Characteristics characteristicID;
}
