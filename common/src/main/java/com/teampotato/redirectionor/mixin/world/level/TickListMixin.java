package com.teampotato.redirectionor.mixin.world.level;

import com.teampotato.redirectionor.references.TickPriorityReferences;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.TickList;
import net.minecraft.world.level.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TickList.class)
public interface TickListMixin<T> {
    @Shadow void scheduleTick(BlockPos pos, T item, int scheduledTime, TickPriority priority);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    default void scheduleTick(BlockPos pos, T item, int scheduledTime) {
        this.scheduleTick(pos, item, scheduledTime, TickPriorityReferences.NORMAL);
    }
}
