package com.cake.system.entity.associations;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.Characteristics;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CakesCharacteristics {
    private Cakes cakeID;
    private Characteristics characteristicID;
}
