package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.pools;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureTemplatePool.class)
public abstract class StructureTemplatePoolMixin {
    @Redirect(method = "method_19310", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }
}
