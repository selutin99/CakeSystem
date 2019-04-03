package com.cake.system.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class CakesDecorations {
    @NonNull
    private Cakes cakeID;
    @NonNull
    private Decorations decorations;
}
