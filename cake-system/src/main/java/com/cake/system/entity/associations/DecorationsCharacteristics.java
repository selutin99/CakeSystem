package com.cake.system.entity.associations;

import com.cake.system.entity.Characteristics;
import com.cake.system.entity.Decorations;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DecorationsCharacteristics {
    private Decorations cakeDecorationID;
    private Characteristics cakeDecorationCharacteristicsID;
}
