package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.blending;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction8;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Set;

@Mixin(value = BlendingData.class, priority = 10)
public abstract class MixinBlendingData {
    @Shadow
    private static int getOutsideIndex(int p_190351_, int p_190352_) {
        throw new RuntimeException();
    }

    @Shadow protected abstract void addValuesForColumn(int p_190300_, ChunkAccess p_190301_, int p_190302_, int p_190303_);
    @Shadow private boolean hasCalculatedData;
    @Shadow @Final private static int CELL_HORIZONTAL_MAX_INDEX_OUTSIDE;
    @Shadow @Final private static int QUARTS_PER_SECTION;
    @Shadow
    private static int getInsideIndex(int p_190331_, int p_190332_) {
        throw new RuntimeException();
    }

    @Redirect(method = "getHeightAtXZ", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "read1", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private static Direction implDownStatic() {
        return Redirectionor.DOWN;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void calculateData(ChunkAccess p_190318_, Set<Direction8> p_190319_) {
        if (!this.hasCalculatedData) {
            if (p_190319_.contains(Redirectionor._8_NORTH) || p_190319_.contains(Redirectionor._8_WEST) || p_190319_.contains(Redirectionor.NORTH_WEST)) this.addValuesForColumn(getInsideIndex(0, 0), p_190318_, 0, 0);

            if (p_190319_.contains(Redirectionor._8_NORTH)) {
                for(int i = 1; i < QUARTS_PER_SECTION; ++i) {
                    this.addValuesForColumn(getInsideIndex(i, 0), p_190318_, 4 * i, 0);
                }
            }

            if (p_190319_.contains(Redirectionor._8_WEST)) {
                for(int j = 1; j < QUARTS_PER_SECTION; ++j) {
                    this.addValuesForColumn(getInsideIndex(0, j), p_190318_, 0, 4 * j);
                }
            }

            if (p_190319_.contains(Redirectionor._8_EAST)) {
                for(int k = 1; k < QUARTS_PER_SECTION; ++k) {
                    this.addValuesForColumn(getOutsideIndex(CELL_HORIZONTAL_MAX_INDEX_OUTSIDE, k), p_190318_, 15, 4 * k);
                }
            }

            if (p_190319_.contains(Redirectionor._8_SOUTH)) {
                for(int l = 0; l < QUARTS_PER_SECTION; ++l) {
                    this.addValuesForColumn(getOutsideIndex(l, CELL_HORIZONTAL_MAX_INDEX_OUTSIDE), p_190318_, 4 * l, 15);
                }
            }

            if (p_190319_.contains(Redirectionor._8_EAST) && p_190319_.contains(Redirectionor.NORTH_EAST)) this.addValuesForColumn(getOutsideIndex(CELL_HORIZONTAL_MAX_INDEX_OUTSIDE, 0), p_190318_, 15, 0);
            if (p_190319_.contains(Redirectionor._8_EAST) && p_190319_.contains(Redirectionor._8_SOUTH) && p_190319_.contains(Redirectionor.SOUTH_EAST)) this.addValuesForColumn(getOutsideIndex(CELL_HORIZONTAL_MAX_INDEX_OUTSIDE, CELL_HORIZONTAL_MAX_INDEX_OUTSIDE), p_190318_, 15, 15);
            this.hasCalculatedData = true;
        }
    }

}
