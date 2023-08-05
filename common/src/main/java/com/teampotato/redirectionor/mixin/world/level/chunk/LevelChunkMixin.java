package com.teampotato.redirectionor.mixin.world.level.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelChunk.class)
public abstract class LevelChunkMixin {
    @Redirect(method = {"replaceWithPacketData", "<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/ChunkPos;Lnet/minecraft/world/level/chunk/UpgradeData;Lnet/minecraft/world/ticks/LevelChunkTicks;Lnet/minecraft/world/ticks/LevelChunkTicks;J[Lnet/minecraft/world/level/chunk/LevelChunkSection;Lnet/minecraft/world/level/chunk/LevelChunk$PostLoadProcessor;Lnet/minecraft/world/level/levelgen/blending/BlendingData;)V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/Heightmap$Types;values()[Lnet/minecraft/world/level/levelgen/Heightmap$Types;"))
    private Heightmap.Types[] redirectHeightmapTypes() {
        return Redirectionor.HEIGHTMAP_TYPES;
    }
}
