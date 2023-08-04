package com.teampotato.redirectionor.mixin.client.gui.screens.inventory;

import com.teampotato.redirectionor.references.MirrorReferences;
import net.minecraft.client.gui.screens.inventory.StructureBlockEditScreen;
import net.minecraft.world.level.block.Mirror;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureBlockEditScreen.class)
public abstract class StructureBlockEditScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Mirror;values()[Lnet/minecraft/world/level/block/Mirror;"))
    private Mirror[] redirectMirrorValues() {
        return MirrorReferences.MIRRORS;
    }
}
