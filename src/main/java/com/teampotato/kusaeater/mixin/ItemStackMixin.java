package com.teampotato.kusaeater.mixin;

import com.teampotato.kusaeater.KusaEater;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract boolean is(Item arg);
    @Shadow private int count;
    @Shadow @Nullable private CompoundTag tag;

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    private void onTick(Level arg, Entity entity, int i, boolean bl, CallbackInfo ci) {
        if (this.is(Items.GRASS) && entity instanceof Player) {
            ((Player) entity).getInventory().removeItem((ItemStack) (Object) this);
            ((Player) entity).getInventory().add(new ItemStack(KusaEater.GRASS.get(), this.count, this.tag));
        }
    }
}
