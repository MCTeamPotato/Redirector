package com.teampotato.redirectionor.mixin.global.rendershape;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({BedBlock.class, ChestBlock.class, ConduitBlock.class, EnderChestBlock.class, ShulkerBoxBlock.class})
public abstract class EntityBlockAnimated {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public RenderShape getRenderShape(BlockState pState) {
        return Redirectionor.ENTITYBLOCK_ANIMATED;
    }
}
