package com.teampotato.redirectionor.mixin.global.down;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AbstractCoralPlantBlock.class, AbstractPressurePlateBlock.class, BannerBlock.class, BubbleColumnBlock.class, CakeBlock.class, CampfireBlock.class, ChorusPlantBlock.class, CoralFinBlock.class, CoralPlantBlock.class, FlowerPotBlock.class, NoteBlock.class, StandingSignBlock.class, TorchBlock.class, DoorBlock.class, DoublePlantBlock.class, RedstoneWireBlock.class, WallBlock.class})
public abstract class InUpdateShape {
    @Redirect(method = "updateShape*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
