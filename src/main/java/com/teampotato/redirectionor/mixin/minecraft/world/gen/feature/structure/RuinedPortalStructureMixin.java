package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Mirror;
import net.minecraft.world.gen.feature.structure.RuinedPortalStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RuinedPortalStructure.Start.class)
public abstract class RuinedPortalStructureMixin {
    @Redirect(method = "generatePieces(Lnet/minecraft/util/registry/DynamicRegistries;Lnet/minecraft/world/gen/ChunkGenerator;Lnet/minecraft/world/gen/feature/template/TemplateManager;IILnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/feature/RuinedPortalFeature;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
    private Mirror implMirrorNone() {
        return Redirectionor.MIRROR_NONE;
    }

    @Redirect(method = "generatePieces(Lnet/minecraft/util/registry/DynamicRegistries;Lnet/minecraft/world/gen/ChunkGenerator;Lnet/minecraft/world/gen/feature/template/TemplateManager;IILnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/feature/RuinedPortalFeature;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;FRONT_BACK:Lnet/minecraft/util/Mirror;"))
    private Mirror implFrontBack() {
        return Redirectionor.FRONT_BACK;
    }
}
