package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LanternBlock.class)
public abstract class MixinLanternBlock {
    @Shadow @Final public static BooleanProperty HANGING;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    protected static Direction getConnectedDirection(BlockState p_153496_) {
        return p_153496_.getValue(HANGING) ? Redirectionor.DOWN : Redirectionor.UP;
    }
}
