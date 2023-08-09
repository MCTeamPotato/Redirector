package com.teampotato.redirectionor.mixin.world.entity.animal;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.animal.Parrot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Parrot.class)
public abstract class ParrotMixin {
    @Redirect(method = "finalizeSpawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Parrot$Variant;values()[Lnet/minecraft/world/entity/animal/Parrot$Variant;"))
    private Parrot.Variant[] redirectParrotVariant() {
        return Values.PARROT_VARIANTS;
    }
}
