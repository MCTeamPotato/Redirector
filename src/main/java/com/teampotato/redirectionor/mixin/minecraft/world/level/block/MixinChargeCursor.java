package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SculkSpreader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SculkSpreader.ChargeCursor.class)
public abstract class MixinChargeCursor {
    @Shadow protected static boolean isUnobstructed(LevelAccessor p_222322_, BlockPos p_222323_, Direction p_222324_) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static boolean isMovementUnobstructed(LevelAccessor p_222318_, BlockPos p_222319_, BlockPos p_222320_) {
        if (p_222319_.distManhattan(p_222320_) == 1) {
            return true;
        } else {
            BlockPos blockpos = p_222320_.subtract(p_222319_);
            Direction direction = Direction.fromAxisAndDirection(Redirectionor.X, blockpos.getX() < 0 ? Redirectionor.NEGATIVE : Redirectionor.POSITIVE);
            Direction direction1 = Direction.fromAxisAndDirection(Redirectionor.Y, blockpos.getY() < 0 ? Redirectionor.NEGATIVE : Redirectionor.POSITIVE);
            Direction direction2 = Direction.fromAxisAndDirection(Redirectionor.Z, blockpos.getZ() < 0 ? Redirectionor.NEGATIVE : Redirectionor.POSITIVE);
            if (blockpos.getX() == 0) {
                return isUnobstructed(p_222318_, p_222319_, direction1) || isUnobstructed(p_222318_, p_222319_, direction2);
            } else if (blockpos.getY() == 0) {
                return isUnobstructed(p_222318_, p_222319_, direction) || isUnobstructed(p_222318_, p_222319_, direction2);
            } else {
                return isUnobstructed(p_222318_, p_222319_, direction) || isUnobstructed(p_222318_, p_222319_, direction1);
            }
        }
    }
}
