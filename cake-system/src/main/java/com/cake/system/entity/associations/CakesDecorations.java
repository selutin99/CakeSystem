package com.cake.system.entity.associations;

import com.cake.system.entity.Cakes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CakesDecorations {
    private int cakeID;
    private int decorations;
}
