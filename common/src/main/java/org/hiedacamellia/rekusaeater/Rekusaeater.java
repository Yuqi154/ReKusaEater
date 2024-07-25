package org.hiedacamellia.rekusaeater;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public final class Rekusaeater {
    public static final String MOD_ID = "rekusaeater";

    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<Item> KUSA = ITEMS.register("kusa", () ->
            new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.6f).build()).arch$tab(Rekusaeater.REKUSAEATER)));
    // Registering a new creative tab
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> REKUSAEATER = TABS.register("rekusaeater", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".rekusaeater"),
                    () -> new ItemStack(KUSA.get())));


    public static void init() {
        ITEMS.register();
        TABS.register();
        // Write common init code here.
    }
}
