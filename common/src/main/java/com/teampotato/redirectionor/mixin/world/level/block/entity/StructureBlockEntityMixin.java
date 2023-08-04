package com.teampotato.redirectionor.mixin.world.level.block.entity;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.StructureBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureBlockEntity.class)
public abstract class StructureBlockEntityMixin {
    @Redirect(method = "load", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }
}
