package com.teampotato.redirectionor.mixin.gametest.framework;

import com.teampotato.redirectionor.references.MirrorReferences;
import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.gametest.framework.StructureUtils;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureUtils.class)
public abstract class StructureUtilsMixin {
    @Redirect(method = "spawnStructure", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationCOUNTERCLOCKWISE_90() {
        return RotationReferences.COUNTERCLOCKWISE_90;
    }

    @Redirect(method = "spawnStructure", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_180:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationCLOCKWISE_180() {
        return RotationReferences.CLOCKWISE_180;
    }

    @Redirect(method = "spawnStructure", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationCLOCKWISE_90() {
        return RotationReferences.CLOCKWISE_90;
    }

    @Redirect(method = {"getRotationForRotationSteps", "spawnStructure"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }
    @Redirect(method = {
            "getStructureBoundingBox(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Vec3i;Lnet/minecraft/world/level/block/Rotation;)Lnet/minecraft/world/level/levelgen/structure/BoundingBox;",
            "addCommandBlockAndButtonToStartTest",
            "getStructureBounds",
            "getStructureBoundingBox(Lnet/minecraft/world/level/block/entity/StructureBlockEntity;)Lnet/minecraft/world/level/levelgen/structure/BoundingBox;"
    }, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Mirror;NONE:Lnet/minecraft/world/level/block/Mirror;"))
    private static Mirror redirectMirrorNONE() {
        return MirrorReferences.NONE;
    }
}
