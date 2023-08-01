package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.references.TickPriorityReferences;
import net.minecraft.world.level.TickPriority;
import net.minecraft.world.level.block.ComparatorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ComparatorBlock.class)
public abstract class ComparatorBlockMixin {
    @Redirect(method = "checkTickOnNeighbor", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/TickPriority;NORMAL:Lnet/minecraft/world/level/TickPriority;"))
    private TickPriority redirectTickPriorityNORMAL() {
        return TickPriorityReferences.NORMAL;
    }

    @Redirect(method = "checkTickOnNeighbor", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/TickPriority;HIGH:Lnet/minecraft/world/level/TickPriority;"))
    private TickPriority redirectTickPriorityHIGH() {
        return TickPriorityReferences.HIGH;
    }
}
