package com.teampotato.redirectionor.mixin.world.gen.surfacebuilders;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.surfacebuilders.ValleySurfaceBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ValleySurfaceBuilder.class)
public abstract class ValleySurfaceBuilderMixin {
    @Redirect(method = "apply(Ljava/util/Random;Lnet/minecraft/world/chunk/IChunk;Lnet/minecraft/world/biome/Biome;IIIDLnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;IJLnet/minecraft/world/gen/surfacebuilders/SurfaceBuilderConfig;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "apply(Ljava/util/Random;Lnet/minecraft/world/chunk/IChunk;Lnet/minecraft/world/biome/Biome;IIIDLnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;IJLnet/minecraft/world/gen/surfacebuilders/SurfaceBuilderConfig;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
