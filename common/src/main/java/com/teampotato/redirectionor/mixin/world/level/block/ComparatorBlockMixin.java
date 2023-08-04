package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.references.TickPriorityReferences;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.ticks.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ComparatorBlock.class)
public abstract class ComparatorBlockMixin {
    @Redirect(method = "checkTickOnNeighbor", at = @At(value = "FIELD", target = "Lnet/minecraft/world/ticks/TickPriority;NORMAL:Lnet/minecraft/world/ticks/TickPriority;"))
    private TickPriority redirectTickPriorityNORMAL() {
        return TickPriorityReferences.NORMAL;
    }

    @Redirect(method = "checkTickOnNeighbor", at = @At(value = "FIELD", target = "Lnet/minecraft/world/ticks/TickPriority;HIGH:Lnet/minecraft/world/ticks/TickPriority;"))
    private TickPriority redirectTickPriorityHIGH() {
        return TickPriorityReferences.HIGH;
    }
}
