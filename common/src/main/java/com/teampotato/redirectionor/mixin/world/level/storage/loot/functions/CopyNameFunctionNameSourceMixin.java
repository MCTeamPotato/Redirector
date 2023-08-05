package com.teampotato.redirectionor.mixin.world.level.storage.loot.functions;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CopyNameFunction.NameSource.class)
public abstract class CopyNameFunctionNameSourceMixin {
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/functions/CopyNameFunction$NameSource;values()[Lnet/minecraft/world/level/storage/loot/functions/CopyNameFunction$NameSource;"))
    private static CopyNameFunction.NameSource[] redirectCopyNameFunctionNameSource() {
        return Redirectionor.COPY_NAME_FUNCTION_NAME_SOURCES;
    }
}
