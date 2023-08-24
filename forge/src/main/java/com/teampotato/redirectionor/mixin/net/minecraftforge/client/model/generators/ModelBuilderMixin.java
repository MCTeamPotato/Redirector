package com.teampotato.redirectionor.mixin.net.minecraftforge.client.model.generators;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraftforge.client.model.generators.ModelBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModelBuilder.class, remap = false)
public abstract class ModelBuilderMixin {
    @Redirect(method = "lambda$toJson$0", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionValues() {
        return Redirectionor.DIRECTIONS;
    }
}
