package com.teampotato.redirectionor.mixin.global.down;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BannerBlock.class, StandingSignBlock.class, VineBlock.class, WallBlock.class, TorchBlock.class, RedStoneWireBlock.class, DoublePlantBlock.class, BaseCoralPlantTypeBlock.class, BasePressurePlateBlock.class, BigDripleafBlock.class, BigDripleafStemBlock.class, BubbleColumnBlock.class, CakeBlock.class, CampfireBlock.class, CandleCakeBlock.class, ChorusPlantBlock.class, CoralFanBlock.class, CoralPlantBlock.class, DoorBlock.class, FlowerPotBlock.class, NoteBlock.class, PointedDripstoneBlock.class})
public abstract class InUpdateShape {
    @Redirect(method = "updateShape*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
