package com.teampotato.kusaeater;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class Grass extends Item {

    public Grass() {
        super(new Properties().food((new FoodProperties.Builder()).nutrition(KusaEater.nutrition.get()).saturationMod(KusaEater.saturationMod.get()).build()).tab(CreativeModeTab.TAB_FOOD));
    }
}
