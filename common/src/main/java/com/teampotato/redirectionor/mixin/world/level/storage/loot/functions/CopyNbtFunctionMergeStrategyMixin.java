package com.teampotato.redirectionor.mixin.world.level.storage.loot.functions;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CopyNbtFunction.MergeStrategy.class)
public abstract class CopyNbtFunctionMergeStrategyMixin {
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/functions/CopyNbtFunction$MergeStrategy;values()[Lnet/minecraft/world/level/storage/loot/functions/CopyNbtFunction$MergeStrategy;"))
    private static CopyNbtFunction.MergeStrategy[] redirectCopyNbtFunctionMergeStrategy() {
        return Redirectionor.COPY_NAME_FUNCTION_MERGE_STRATEGIES;
    }
}
