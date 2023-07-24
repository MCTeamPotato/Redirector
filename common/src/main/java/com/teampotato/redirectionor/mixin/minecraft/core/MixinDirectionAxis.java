package com.teampotato.redirectionor.mixin.minecraft.core;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Direction.Axis.class, priority = 10)
public abstract class MixinDirectionAxis {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction.Plane getPlane() {
        switch ((Direction.Axis) (Object) this) {
            case X:
            case Z:
                return Redirectionor.HORIZONTAL;
            case Y:
                return Redirectionor.VERTICAL;
            default:
                throw new Error("Someone's been tampering with the universe!");
        }
    }
}
