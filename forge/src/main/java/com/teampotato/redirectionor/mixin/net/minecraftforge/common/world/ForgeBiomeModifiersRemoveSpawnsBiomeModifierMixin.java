package com.teampotato.redirectionor.mixin.net.minecraftforge.common.world;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ForgeBiomeModifiers.RemoveSpawnsBiomeModifier.class, remap = false)
public abstract class ForgeBiomeModifiersRemoveSpawnsBiomeModifierMixin {
    @Redirect(method = "modify", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/MobCategory;values()[Lnet/minecraft/world/entity/MobCategory;"))
    private MobCategory[] redirectMobCategory() {
        return Redirectionor.MOB_CATEGORIES;
    }
}
