package com.teampotato.redirectionor.mixin.world.level.levelgen.feature;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.WoodlandMansionFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class WoodlandMansionFeatureMixin {
    @Mixin(WoodlandMansionFeature.WoodlandMansionStart.class)
    public abstract static class WoodlandMansionStartMixin {
        @Redirect(method = "generatePieces(Lnet/minecraft/core/RegistryAccess;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureManager;IILnet/minecraft/world/level/biome/Biome;Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationCOUNTERCLOCKWISE_90() {
            return RotationReferences.COUNTERCLOCKWISE_90;
        }

        @Redirect(method = "generatePieces(Lnet/minecraft/core/RegistryAccess;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureManager;IILnet/minecraft/world/level/biome/Biome;Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_180:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationCLOCKWISE_180() {
            return RotationReferences.CLOCKWISE_180;
        }

        @Redirect(method = "generatePieces(Lnet/minecraft/core/RegistryAccess;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureManager;IILnet/minecraft/world/level/biome/Biome;Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationCLOCKWISE_90() {
            return RotationReferences.CLOCKWISE_90;
        }
    }
}
