package com.teampotato.redirectionor.mixin.net.minecraft.client.gui.screens.inventory;

import net.minecraft.client.gui.screens.inventory.StructureBlockEditScreen;
import net.minecraft.world.level.block.Mirror;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureBlockEditScreen.class)
public abstract class StructureBlockEditScreenMixin {
    @Unique
    static final Mirror[] redirectionor$MIRRORS = Mirror.values();
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Mirror;values()[Lnet/minecraft/world/level/block/Mirror;"))
    private Mirror[] redirectMirror() {
        return redirectionor$MIRRORS;
    }
}
