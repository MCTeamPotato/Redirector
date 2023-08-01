package com.teampotato.redirectionor.mixin.world.level;

import com.teampotato.redirectionor.references.TickPriorityReferences;
import net.minecraft.world.level.TickNextTickData;
import net.minecraft.world.level.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TickNextTickData.class)
public abstract class TickNextTickDataMixin {
    @Redirect(method = "<init>(Lnet/minecraft/core/BlockPos;Ljava/lang/Object;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/TickPriority;NORMAL:Lnet/minecraft/world/level/TickPriority;"))
    private static TickPriority redirectTickPriorityNORMAL() {
        return TickPriorityReferences.NORMAL;
    }
}
