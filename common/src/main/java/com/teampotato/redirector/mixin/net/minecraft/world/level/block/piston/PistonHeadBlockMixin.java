package com.teampotato.redirector.mixin.net.minecraft.world.level.block.piston;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PistonHeadBlock.class)
public abstract class PistonHeadBlockMixin {
    @Shadow
    private static VoxelShape calculateShape(Direction direction, boolean shortArm) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid stream and {@link Direction#values()} allocation
     */
    @Overwrite
    private static VoxelShape @NotNull [] makeShapes(boolean extended) {
        VoxelShape[] voxelShapes = new VoxelShape[CommonValues.directionsLength];
        for (Direction direction : CommonValues.DIRECTIONS) voxelShapes[direction.ordinal()] = calculateShape(direction, extended);
        return voxelShapes;
    }
}
