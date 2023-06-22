package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.SeaGrassBlock;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.block.TallSeaGrassBlock;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.BlockPileFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({SeaGrassBlock.class, SeaPickleBlock.class, TallSeaGrassBlock.class, BlockPileFeature.class})
public abstract class InMayPlaceOn {
    @Redirect(method = "mayPlaceOn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
