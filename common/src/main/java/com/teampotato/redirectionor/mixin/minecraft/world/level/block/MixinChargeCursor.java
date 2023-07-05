package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SculkSpreader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = SculkSpreader.ChargeCursor.class, priority = 10)
public abstract class MixinChargeCursor {
    @Shadow
    private static boolean isUnobstructed(LevelAccessor p_222322_, BlockPos p_222323_, Direction p_222324_) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static boolean isMovementUnobstructed(LevelAccessor level, BlockPos fromPos, BlockPos toPos) {
        if (fromPos.distManhattan(toPos) == 1) {
            return true;
        } else {
            BlockPos blockPos = toPos.subtract(fromPos);
            Direction direction = Direction.fromAxisAndDirection(Redirectionor.X, blockPos.getX() < 0 ? Redirectionor.NEGATIVE : Redirectionor.POSITIVE);
            Direction direction2 = Direction.fromAxisAndDirection(Redirectionor.Y, blockPos.getY() < 0 ? Redirectionor.NEGATIVE : Redirectionor.POSITIVE);
            Direction direction3 = Direction.fromAxisAndDirection(Redirectionor.Z, blockPos.getZ() < 0 ? Redirectionor.NEGATIVE : Redirectionor.POSITIVE);
            if (blockPos.getX() == 0) {
                return isUnobstructed(level, fromPos, direction2) || isUnobstructed(level, fromPos, direction3);
            } else if (blockPos.getY() == 0) {
                return isUnobstructed(level, fromPos, direction) || isUnobstructed(level, fromPos, direction3);
            } else {
                return isUnobstructed(level, fromPos, direction) || isUnobstructed(level, fromPos, direction2);
            }
        }
    }
}
