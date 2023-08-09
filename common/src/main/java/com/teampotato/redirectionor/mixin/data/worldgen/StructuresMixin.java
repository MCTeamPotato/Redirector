package com.teampotato.redirectionor.mixin.data.worldgen;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.world.entity.MobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Structures.class)
public abstract class StructuresMixin {
    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/MobCategory;values()[Lnet/minecraft/world/entity/MobCategory;"))
    private static MobCategory[] redirectMobCategory() {
        return Values.MOB_CATEGORIES;
    }
}
