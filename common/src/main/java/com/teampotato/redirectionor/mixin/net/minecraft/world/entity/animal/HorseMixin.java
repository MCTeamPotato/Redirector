package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.animal;

import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Markings;
import net.minecraft.world.entity.animal.horse.Variant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Horse.class)
public abstract class HorseMixin {
    @Unique
    static final Variant[] redirectionor$VARIANTS = Variant.values();
    @Unique
    static final Markings[] redirectionor$MARKINGS = Markings.values();
    @Redirect(method = {"getBreedOffspring", "finalizeSpawn"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Variant;values()[Lnet/minecraft/world/entity/animal/horse/Variant;"))
    private Variant[] redirectVariant() {
        return redirectionor$VARIANTS;
    }
    @Redirect(method = {"getBreedOffspring", "finalizeSpawn"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Markings;values()[Lnet/minecraft/world/entity/animal/horse/Markings;"))
    private Markings[] redirectMarkings() {
        return redirectionor$MARKINGS;
    }
}
