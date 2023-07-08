package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BambooSaplingBlock.class, BambooStalkBlock.class, WallBlock.class, BambooSaplingBlock.class, BigDripleafBlock.class, BigDripleafStemBlock.class, BubbleColumnBlock.class, ChorusFlowerBlock.class, DirtPathBlock.class, DoorBlock.class, FarmBlock.class, HangingRootsBlock.class, MagmaBlock.class, MangrovePropaguleBlock.class, PointedDripstoneBlock.class, RedStoneWireBlock.class, SnowyDirtBlock.class, SoulSandBlock.class, SporeBlossomBlock.class})
public abstract class InUpdateShape {
    @Redirect(method = "updateShape*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
