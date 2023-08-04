package com.teampotato.redirectionor.mixin.gametest.framework;

import com.teampotato.redirectionor.references.MirrorReferences;
import net.minecraft.world.level.block.Mirror;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.gametest.framework.ReportGameListener")
public class ReportGameListenerMixin {
    @Redirect(method = {"spawnBeacon", "spawnLectern"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Mirror;NONE:Lnet/minecraft/world/level/block/Mirror;"))
    private static Mirror redirectMirrorNONE() {
        return MirrorReferences.NONE;
    }
}
