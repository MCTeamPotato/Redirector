package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.WaterloggedVegetationPatchFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(WaterloggedVegetationPatchFeature.class)
public abstract class MixinWaterloggedVegetationPatchFeature {
    @Shadow
    private static boolean isExposedDirection(WorldGenLevel pLevel, BlockPos pPos, BlockPos.MutableBlockPos pMutablePos, Direction pDirection) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static boolean isExposed(WorldGenLevel pLevel, Set<BlockPos> pPositions, BlockPos pPos, BlockPos.MutableBlockPos pMutablePos) {
        return
                isExposedDirection(pLevel, pPos, pMutablePos, Redirectionor.NORTH) ||
                isExposedDirection(pLevel, pPos, pMutablePos, Redirectionor.EAST) ||
                isExposedDirection(pLevel, pPos, pMutablePos, Redirectionor.SOUTH) ||
                isExposedDirection(pLevel, pPos, pMutablePos, Redirectionor.WEST) ||
                isExposedDirection(pLevel, pPos, pMutablePos, Redirectionor.DOWN);
    }
}
