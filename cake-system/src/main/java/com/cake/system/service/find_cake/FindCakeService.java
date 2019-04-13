package com.cake.system.service.find_cake;

import com.cake.system.entity.Cakes;
import com.cake.system.entity.CakesBases;
import com.cake.system.entity.Decorations;

import java.util.List;

public interface FindCakeService {
    //Искать по основам торта
    List<Cakes> findCakeByBases(CakesBases cakesBases);
    List<Cakes> findCakeByBases(int cakesBasesID);

    //Искать по украшениям
    List<Cakes> findCakeByDecor(Decorations deco);
    List<Cakes> findCakeByDecor(int decoID);
}
