package com.teampotato.redirectionor.mixin.util.datafix.fixes;

import com.teampotato.redirectionor.references.ChunkPalettedStorageFixDirectionReferences;
import net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class ChunkPalettedStorageFixMixin {
    @Mixin(targets = "net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix$UpgradeChunk")
    public abstract static class UpgradeChunkMixin {
        @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/datafix/fixes/ChunkPalettedStorageFix$Direction;UP:Lnet/minecraft/util/datafix/fixes/ChunkPalettedStorageFix$Direction;"))
        private ChunkPalettedStorageFix.Direction redirectChunkPalettedStorageFixDirectionUP() {
            return ChunkPalettedStorageFixDirectionReferences.UP;
        }

        @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/datafix/fixes/ChunkPalettedStorageFix$Direction;DOWN:Lnet/minecraft/util/datafix/fixes/ChunkPalettedStorageFix$Direction;"))
        private ChunkPalettedStorageFix.Direction redirectChunkPalettedStorageFixDirectionDOWN() {
            return ChunkPalettedStorageFixDirectionReferences.DOWN;
        }
    }
}
