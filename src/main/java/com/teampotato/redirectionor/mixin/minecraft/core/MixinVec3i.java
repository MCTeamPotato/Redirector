package com.teampotato.redirectionor.mixin.minecraft.core;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Vec3i.class)
public abstract class MixinVec3i {
    @Shadow public abstract Vec3i relative(Direction pDirection, int pDistance);
    @Shadow public abstract int getX();
    @Shadow public abstract int getY();
    @Shadow public abstract int getZ();

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i above(int pDistance) {
        return this.relative(Redirectionor.UP, pDistance);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i below(int pDistance) {
        return this.relative(Redirectionor.DOWN, pDistance);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i north(int pDistance) {
        return this.relative(Direction.NORTH, pDistance);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i south(int pDistance) {
        return this.relative(Direction.SOUTH, pDistance);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i west(int pDistance) {
        return this.relative(Direction.WEST, pDistance);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i east(int pDistance) {
        return this.relative(Direction.EAST, pDistance);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Vec3i relative(Direction.Axis pAxis, int pAmount) {
        if (pAmount == 0) {
            return ((Vec3i) (Object)this);
        } else {
            int i = pAxis == Redirectionor.X ? pAmount : 0;
            int j = pAxis == Redirectionor.Y ? pAmount : 0;
            int k = pAxis == Redirectionor.Z ? pAmount : 0;
            return new Vec3i(this.getX() + i, this.getY() + j, this.getZ() + k);
        }
    }
}
