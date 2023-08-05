package com.teampotato.redirectionor.mixin.commands.arguments;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.commands.arguments.HeightmapTypeArgument;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HeightmapTypeArgument.class)
public abstract class HeightmapTypeArgumentMixin {
    @Redirect(method = "keptTypes", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/Heightmap$Types;values()[Lnet/minecraft/world/level/levelgen/Heightmap$Types;"))
    private static Heightmap.Types[] redirectHeightmapTypes() {
        return Redirectionor.HEIGHTMAP_TYPES;
    }
}
