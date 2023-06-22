package com.teampotato.redirectionor.mixin.minecraft.util;

import com.mojang.datafixers.util.Pair;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Predicate;

@Mixin(value = TeleportationRepositioner.class, priority = 10)
public abstract class TeleportationRepositionerMixin {
    @Shadow private static int getLimit(Predicate<BlockPos> pPosPredicate, BlockPos.Mutable pCenterPos, Direction pDirection, int pMax) {
        return 0;
    }

    @Shadow static Pair<TeleportationRepositioner.IntBounds, Integer> getMaxRectangleLocation(int[] pHeights) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public static TeleportationRepositioner.Result getLargestRectangleAround(BlockPos pCenterPos, Direction.Axis pAxis1, int pMax1, Direction.Axis pAxis2, int pMax2, Predicate<BlockPos> pPosPredicate) {
        BlockPos.Mutable blockpos$mutable = pCenterPos.mutable();
        Direction direction = Direction.get(Redirectionor.NEGATIVE, pAxis1);
        Direction direction1 = direction.getOpposite();
        Direction direction2 = Direction.get(Redirectionor.NEGATIVE, pAxis2);
        Direction direction3 = direction2.getOpposite();
        int i = getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos), direction, pMax1);
        int j = getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos), direction1, pMax1);
        TeleportationRepositioner.IntBounds[] ateleportationrepositioner$intbounds = new TeleportationRepositioner.IntBounds[i + 1 + j];
        ateleportationrepositioner$intbounds[i] = new TeleportationRepositioner.IntBounds(getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos), direction2, pMax2), getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos), direction3, pMax2));
        int l = ateleportationrepositioner$intbounds[i].min;

        for(int i1 = 1; i1 <= i; ++i1) {
            TeleportationRepositioner.IntBounds teleportationrepositioner$intbounds = ateleportationrepositioner$intbounds[i - (i1 - 1)];
            ateleportationrepositioner$intbounds[i - i1] = new TeleportationRepositioner.IntBounds(getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos).move(direction, i1), direction2, teleportationrepositioner$intbounds.min), getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos).move(direction, i1), direction3, teleportationrepositioner$intbounds.max));
        }

        for(int l2 = 1; l2 <= j; ++l2) {
            TeleportationRepositioner.IntBounds teleportationrepositioner$intbounds2 = ateleportationrepositioner$intbounds[i + l2 - 1];
            ateleportationrepositioner$intbounds[i + l2] = new TeleportationRepositioner.IntBounds(getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos).move(direction1, l2), direction2, teleportationrepositioner$intbounds2.min), getLimit(pPosPredicate, blockpos$mutable.set(pCenterPos).move(direction1, l2), direction3, teleportationrepositioner$intbounds2.max));
        }

        int i3 = 0;
        int j3 = 0;
        int j1 = 0;
        int k1 = 0;
        int[] aint = new int[ateleportationrepositioner$intbounds.length];

        for(int l1 = l; l1 >= 0; --l1) {
            for(int i2 = 0; i2 < ateleportationrepositioner$intbounds.length; ++i2) {
                TeleportationRepositioner.IntBounds teleportationrepositioner$intbounds1 = ateleportationrepositioner$intbounds[i2];
                int j2 = l - teleportationrepositioner$intbounds1.min;
                int k2 = l + teleportationrepositioner$intbounds1.max;
                aint[i2] = l1 >= j2 && l1 <= k2 ? k2 + 1 - l1 : 0;
            }

            Pair<TeleportationRepositioner.IntBounds, Integer> pair = getMaxRectangleLocation(aint);
            TeleportationRepositioner.IntBounds teleportationrepositioner$intbounds3 = pair.getFirst();
            int k3 = 1 + teleportationrepositioner$intbounds3.max - teleportationrepositioner$intbounds3.min;
            int l3 = pair.getSecond();
            if (k3 * l3 > j1 * k1) {
                i3 = teleportationrepositioner$intbounds3.min;
                j3 = l1;
                j1 = k3;
                k1 = l3;
            }
        }

        return new TeleportationRepositioner.Result(pCenterPos.relative(pAxis1, i3 - i).relative(pAxis2, j3 - l), j1, k1);
    }
}
