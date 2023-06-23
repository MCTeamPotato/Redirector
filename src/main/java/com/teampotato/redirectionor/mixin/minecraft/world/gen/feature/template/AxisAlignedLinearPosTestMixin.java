package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.template;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.feature.template.AxisAlignedLinearPosTest;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(value = AxisAlignedLinearPosTest.class, priority = 10)
public abstract class AxisAlignedLinearPosTestMixin {
    @Shadow @Final private float minChance;
    @Shadow @Final private Direction.Axis axis;
    @Shadow @Final private float maxChance;
    @Shadow @Final private int minDist;
    @Shadow @Final private int maxDist;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean test(BlockPos p_230385_1_, BlockPos p_230385_2_, BlockPos p_230385_3_, Random pRandom) {
        Direction direction = Direction.get(Redirectionor.POSITIVE, this.axis);
        float f = (float)Math.abs((p_230385_2_.getX() - p_230385_3_.getX()) * direction.getStepX());
        float f1 = (float)Math.abs((p_230385_2_.getY() - p_230385_3_.getY()) * direction.getStepY());
        float f2 = (float)Math.abs((p_230385_2_.getZ() - p_230385_3_.getZ()) * direction.getStepZ());
        int i = (int)(f + f1 + f2);
        float f3 = pRandom.nextFloat();
        return (double)f3 <= MathHelper.clampedLerp(this.minChance, this.maxChance, MathHelper.inverseLerp(i, this.minDist, this.maxDist));
    }
}
