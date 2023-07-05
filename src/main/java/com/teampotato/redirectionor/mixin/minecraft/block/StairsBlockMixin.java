package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StairsBlock.class)
public abstract class StairsBlockMixin {
    @Redirect(method = {"getShape", "getStateForPlacement"}, at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;TOP:Lnet/minecraft/state/properties/Half;"))
    private Half implTop() {
        return Redirectionor.TOP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;BOTTOM:Lnet/minecraft/state/properties/Half;"))
    private Half implBottom() {
        return Redirectionor.BOTTOM;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;STRAIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implStraight() {
        return Redirectionor.STRAIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;INNER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implInnerLeft() {
        return Redirectionor.INNER_LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;INNER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implInnerRight() {
        return Redirectionor.INNER_RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implOuterLeft() {
        return Redirectionor.OUTER_LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implOuterRight() {
        return Redirectionor.OUTER_RIGHT;
    }
}
