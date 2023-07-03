package com.teampotato.redirectionor.mixin.minecraft.world.phys;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(AABB.class)
public abstract class MixinAABB {
    @Shadow @Nullable
    private static Direction clipPoint(double[] pMinDistance, @org.jetbrains.annotations.Nullable Direction pPrevDirection, double pDistanceSide, double pDistanceOtherA, double pDistanceOtherB, double pMinSide, double pMinOtherA, double pMaxOtherA, double pMinOtherB, double pMaxOtherB, Direction pHitSide, double pStartSide, double pStartOtherA, double pStartOtherB) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @Nullable
    private static Direction getDirection(AABB pAabb, Vec3 pStart, double[] pMinDistance, @Nullable Direction pFacing, double pDeltaX, double pDeltaY, double pDeltaZ) {
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
