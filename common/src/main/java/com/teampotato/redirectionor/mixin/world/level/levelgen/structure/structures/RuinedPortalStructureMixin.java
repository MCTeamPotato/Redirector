package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.structures.RuinedPortalStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RuinedPortalStructure.class)
public abstract class RuinedPortalStructureMixin {
    @Redirect(method = "findGenerationPoint", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Rotation;values()[Lnet/minecraft/world/level/block/Rotation;"))
    private Rotation[] redirectRotation() {
        return Values.ROTATIONS;
    }
}
