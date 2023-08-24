package com.teampotato.redirectionor.mixin.net.minecraft.world.level.storage.loot.functions;

import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CopyNameFunction.NameSource.class)
public abstract class CopyNameFunctionNameSourceMixin {
    @Unique
    static final CopyNameFunction.NameSource[] COPY_NAME_FUNCTION_NAME_SOURCES = CopyNameFunction.NameSource.values();
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/functions/CopyNameFunction$NameSource;values()[Lnet/minecraft/world/level/storage/loot/functions/CopyNameFunction$NameSource;"))
    private static CopyNameFunction.NameSource[] redirectCopyNameFunctionNameSource() {
        return COPY_NAME_FUNCTION_NAME_SOURCES;
    }
}
