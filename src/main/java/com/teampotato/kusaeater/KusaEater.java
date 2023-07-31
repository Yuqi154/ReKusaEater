package com.teampotato.kusaeater;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(KusaEater.MOD_ID)
public class KusaEater {
    public static final String MOD_ID = "kusaeater";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> GRASS = ITEMS.register("grass", Grass::new);

    public KusaEater() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, config);
    }

    public static ForgeConfigSpec config;
    public static ForgeConfigSpec.IntValue nutrition;
    public static ForgeConfigSpec.ConfigValue<Float> saturationMod;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("KusaEater");
        nutrition = builder.defineInRange("nutrition", 3, 0, Integer.MAX_VALUE);
        saturationMod = builder.defineInRange("saturationMod", 0.6F, 0.0F, Float.MAX_VALUE, Float.class);
        builder.pop();
        config = builder.build();
    }
}