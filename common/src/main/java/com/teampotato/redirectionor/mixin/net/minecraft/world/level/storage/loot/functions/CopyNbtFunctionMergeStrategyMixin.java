package com.teampotato.redirectionor.mixin.net.minecraft.world.level.storage.loot.functions;

import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CopyNbtFunction.MergeStrategy.class)
public abstract class CopyNbtFunctionMergeStrategyMixin {
    @Unique
  private static final CopyNbtFunction.MergeStrategy[] COPY_NAME_FUNCTION_MERGE_STRATEGIES = CopyNbtFunction.MergeStrategy.values();
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/functions/CopyNbtFunction$MergeStrategy;values()[Lnet/minecraft/world/level/storage/loot/functions/CopyNbtFunction$MergeStrategy;"))
    private static CopyNbtFunction.MergeStrategy[] redirectCopyNbtFunctionMergeStrategy() {
        return COPY_NAME_FUNCTION_MERGE_STRATEGIES;
    }
}
