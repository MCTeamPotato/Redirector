package com.teampotato.redirector.mixin.net.minecraft.server.commands;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.commands.DebugMobSpawningCommand;
import net.minecraft.world.entity.MobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DebugMobSpawningCommand.class)
public abstract class DebugMobSpawningCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/MobCategory;values()[Lnet/minecraft/world/entity/MobCategory;"))
    private static MobCategory[] redirectMobCategories() {
        return CommonValues.MOB_CATEGORIES;
    }
}
