package com.cake.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakesDecorations {
    private Cakes cakeID;
    private Decorations decorations;
}
