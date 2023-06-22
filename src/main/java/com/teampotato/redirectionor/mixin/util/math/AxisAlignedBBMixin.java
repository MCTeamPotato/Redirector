package com.teampotato.redirectionor.mixin.util.math;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(value = AxisAlignedBB.class, priority = 10)
public abstract class AxisAlignedBBMixin {
    @Shadow @Nullable
    private static Direction clipPoint(double[] pMinDistance, @Nullable Direction pPrevDirection, double pDistanceSide, double pDistanceOtherA, double pDistanceOtherB, double pMinSide, double pMinOtherA, double pMaxOtherA, double pMinOtherB, double pMaxOtherB, Direction pHitSide, double pStartSide, double pStartOtherA, double pStartOtherB) {
        return null;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @Nullable
    private static Direction getDirection(AxisAlignedBB pAabb, Vector3d pStart, double[] pMinDistance, @Nullable Direction pFacing, double pDeltaX, double pDeltaY, double pDeltaZ) {
        if (pDeltaX > 1.0E-7D) {
            pFacing = clipPoint(pMinDistance, pFacing, pDeltaX, pDeltaY, pDeltaZ, pAabb.minX, pAabb.minY, pAabb.maxY, pAabb.minZ, pAabb.maxZ, Redirectionor.WEST, pStart.x, pStart.y, pStart.z);
        } else if (pDeltaX < -1.0E-7D) {
            pFacing = clipPoint(pMinDistance, pFacing, pDeltaX, pDeltaY, pDeltaZ, pAabb.maxX, pAabb.minY, pAabb.maxY, pAabb.minZ, pAabb.maxZ, Redirectionor.EAST, pStart.x, pStart.y, pStart.z);
        }

        if (pDeltaY > 1.0E-7D) {
            pFacing = clipPoint(pMinDistance, pFacing, pDeltaY, pDeltaZ, pDeltaX, pAabb.minY, pAabb.minZ, pAabb.maxZ, pAabb.minX, pAabb.maxX, Redirectionor.DOWN, pStart.y, pStart.z, pStart.x);
        } else if (pDeltaY < -1.0E-7D) {
            pFacing = clipPoint(pMinDistance, pFacing, pDeltaY, pDeltaZ, pDeltaX, pAabb.maxY, pAabb.minZ, pAabb.maxZ, pAabb.minX, pAabb.maxX, Redirectionor.UP, pStart.y, pStart.z, pStart.x);
        }

        if (pDeltaZ > 1.0E-7D) {
            pFacing = clipPoint(pMinDistance, pFacing, pDeltaZ, pDeltaX, pDeltaY, pAabb.minZ, pAabb.minX, pAabb.maxX, pAabb.minY, pAabb.maxY, Redirectionor.NORTH, pStart.z, pStart.x, pStart.y);
        } else if (pDeltaZ < -1.0E-7D) {
            pFacing = clipPoint(pMinDistance, pFacing, pDeltaZ, pDeltaX, pDeltaY, pAabb.maxZ, pAabb.minX, pAabb.maxX, pAabb.minY, pAabb.maxY, Redirectionor.SOUTH, pStart.z, pStart.x, pStart.y);
        }

        return pFacing;
    }
}
