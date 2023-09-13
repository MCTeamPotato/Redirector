package com.teampotato.redirector.mixin.net.minecraft.world.entity.animal;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Sheep.class)
public class SheepMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private static DyeColor[] redirectDyeColors() {
        return CommonValues.DYE_COLORS;
    }
}
