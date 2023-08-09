package com.teampotato.redirectionor.mixin.world.entity.animal;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TropicalFish.class)
public abstract class TropicalFishMixin {
    @Redirect(method = "finalizeSpawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private DyeColor[] redirectDyeColor() {
        return Values.DYE_COLORS;
    }
    @Redirect(method = "finalizeSpawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/TropicalFish$Pattern;values()[Lnet/minecraft/world/entity/animal/TropicalFish$Pattern;"))
    private TropicalFish.Pattern[] redirectTropicalFishPattern() {
        return Values.TROPICAL_FISH_PATTERNS;
    }
}
