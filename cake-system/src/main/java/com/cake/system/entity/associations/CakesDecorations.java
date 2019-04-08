package com.cake.system.entity.associations;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.Decorations;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CakesDecorations {
    private Cakes cakeID;
    private Decorations decorations;
}
