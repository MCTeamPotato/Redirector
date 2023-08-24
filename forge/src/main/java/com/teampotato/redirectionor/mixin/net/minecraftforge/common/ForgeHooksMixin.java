package com.teampotato.redirectionor.mixin.net.minecraftforge.common;

import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ForgeHooks.class, remap = false)
public abstract class ForgeHooksMixin {
    @Unique private static final PackType[] PACK_TYPES = PackType.values();

    @Redirect(method = "readTypedPackFormats", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/PackType;values()[Lnet/minecraft/server/packs/PackType;"))
    private static PackType[] redirectPackTypeValues() {
        return PACK_TYPES;
    }
}
