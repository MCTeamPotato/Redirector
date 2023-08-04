package com.teampotato.redirectionor.mixin.advancements;

import com.teampotato.redirectionor.references.FrameTypeReferences;
import net.minecraft.advancements.FrameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FrameType.class)
public abstract class FrameTypeMixin {
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/FrameType;values()[Lnet/minecraft/advancements/FrameType;"))
    private static FrameType[] redirectFrameTypeValues() {
        return FrameTypeReferences.FRAME_TYPES;
    }
}
