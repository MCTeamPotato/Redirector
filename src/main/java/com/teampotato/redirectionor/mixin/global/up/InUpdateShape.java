package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BambooBlock.class, WallBlock.class, BambooSaplingBlock.class, BubbleColumnBlock.class, ChorusFlowerBlock.class, DoorBlock.class, DoublePlantBlock.class, FarmlandBlock.class, GrassPathBlock.class, MagmaBlock.class, RedstoneWireBlock.class, SnowyDirtBlock.class, SoulSandBlock.class})
public abstract class InUpdateShape {
    @Redirect(method = "updateShape*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
