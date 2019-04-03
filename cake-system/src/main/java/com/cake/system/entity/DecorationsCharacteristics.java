package com.cake.system.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class DecorationsCharacteristics {
    @NonNull
    private Decorations cakeDecorationID;

    @NonNull
    private Characteristics cakeDecorationCharacteristicsID;
}
