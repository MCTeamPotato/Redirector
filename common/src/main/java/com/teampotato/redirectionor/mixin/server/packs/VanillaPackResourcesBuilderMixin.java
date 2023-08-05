package com.teampotato.redirectionor.mixin.server.packs;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.VanillaPackResourcesBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VanillaPackResourcesBuilder.class)
public abstract class VanillaPackResourcesBuilderMixin {
    @Redirect(method = {"pushUniversalPath", "build"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/PackType;values()[Lnet/minecraft/server/packs/PackType;"))
    private PackType[] redirectPackType() {
        return Redirectionor.PACK_TYPES;
    }
}
