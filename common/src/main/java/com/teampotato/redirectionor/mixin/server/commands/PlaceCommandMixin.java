package com.teampotato.redirectionor.mixin.server.commands;

import com.teampotato.redirectionor.references.MirrorReferences;
import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.server.commands.PlaceCommand;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlaceCommand.class)
public abstract class PlaceCommandMixin {
    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Mirror;NONE:Lnet/minecraft/world/level/block/Mirror;"))
    private Mirror redirectMirrorNONE() {
        return MirrorReferences.NONE;
    }
}
