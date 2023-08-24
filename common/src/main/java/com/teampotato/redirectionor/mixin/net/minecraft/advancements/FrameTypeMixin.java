package com.teampotato.redirectionor.mixin.net.minecraft.advancements;

import net.minecraft.advancements.FrameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FrameType.class)
public abstract class FrameTypeMixin {
    @Unique
    private static final FrameType[] FRAME_TYPES = FrameType.values();
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/FrameType;values()[Lnet/minecraft/advancements/FrameType;"))
    private static FrameType[] redirectFrameType() {
        return FRAME_TYPES;
    }
}