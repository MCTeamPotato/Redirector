package com.teampotato.redirectionor.mixin.minecraft.test;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.test.StructureHelper;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureHelper.class)
public abstract class MixinStructureHelper {
    @Redirect(method = {"getRotationForRotationSteps", "spawnStructure"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private static Rotation implNone() {
        return Redirectionor.NONE;
    }

    @Redirect(method = "getRotationForRotationSteps", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
    private static Rotation implClockWise90() {
        return Redirectionor.CLOCKWISE_90;
    }

    @Redirect(method = "getRotationForRotationSteps", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_180:Lnet/minecraft/util/Rotation;"))
    private static Rotation implClockWise180() {
        return Redirectionor.CLOCKWISE_180;
    }

    @Redirect(method = "getRotationForRotationSteps", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
    private static Rotation implCounterClockWise90() {
        return Redirectionor.COUNTERCLOCKWISE_90;
    }

    @Redirect(method = {"getStructureBounds", "getStructureBoundingBox(Lnet/minecraft/tileentity/StructureBlockTileEntity;)Lnet/minecraft/util/math/MutableBoundingBox;", "addCommandBlockAndButtonToStartTest", "getStructureBoundingBox(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Rotation;)Lnet/minecraft/util/math/MutableBoundingBox;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
    private static Mirror implMirrorNone() {
        return Redirectionor.MIRROR_NONE;
    }
}
