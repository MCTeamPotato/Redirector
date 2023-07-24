package com.teampotato.redirectionor.mixin.minecraft.core;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Vec3i.class, priority = 10)
public abstract class MixinVec3i {
    @Shadow public abstract Vec3i relative(Direction pDirection, int pDistance);

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
}
