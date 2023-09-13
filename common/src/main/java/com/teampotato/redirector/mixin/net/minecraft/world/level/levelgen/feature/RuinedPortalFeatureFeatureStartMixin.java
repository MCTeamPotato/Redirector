package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.feature;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.RuinedPortalFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RuinedPortalFeature.FeatureStart.class)
public abstract class RuinedPortalFeatureFeatureStartMixin {
    @Redirect(method = "generatePieces(Lnet/minecraft/core/RegistryAccess;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureManager;IILnet/minecraft/world/level/biome/Biome;Lnet/minecraft/world/level/levelgen/feature/configurations/RuinedPortalConfiguration;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Rotation;values()[Lnet/minecraft/world/level/block/Rotation;"))
    private Rotation[] redirectRotations() {
        return CommonValues.ROTATIONS;
    }
}
