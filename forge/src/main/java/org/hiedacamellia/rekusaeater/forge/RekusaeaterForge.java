package org.hiedacamellia.rekusaeater.forge;

import org.hiedacamellia.rekusaeater.Rekusaeater;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Rekusaeater.MOD_ID)
public final class RekusaeaterForge {
    public RekusaeaterForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Rekusaeater.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        Rekusaeater.init();
    }
}
