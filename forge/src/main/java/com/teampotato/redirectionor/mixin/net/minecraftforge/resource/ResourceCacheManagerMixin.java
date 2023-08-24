package com.teampotato.redirectionor.mixin.net.minecraftforge.resource;

import net.minecraft.server.packs.PackType;
import net.minecraftforge.resource.ResourceCacheManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@SuppressWarnings("UnstableApiUsage")
@Mixin(value = ResourceCacheManager.class, remap = false)
public abstract class ResourceCacheManagerMixin {
    @Unique
    static final PackType[] PACK_TYPES = PackType.values();
    @Redirect(method = "index", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/PackType;values()[Lnet/minecraft/server/packs/PackType;"))
    private PackType[] redirectPackTypeValues() {
        return PACK_TYPES;
    }
}
