package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.jigsaw;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(JigsawPattern.class)
public abstract class JigsawPatternMixin {
    @Redirect(method = "lambda$getMaxSize$2", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private static Rotation implNone() {
        return Redirectionor.NONE;
    }
}
