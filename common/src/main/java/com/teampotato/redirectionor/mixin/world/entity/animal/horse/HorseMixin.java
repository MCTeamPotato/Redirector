package com.teampotato.redirectionor.mixin.world.entity.animal.horse;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Markings;
import net.minecraft.world.entity.animal.horse.Variant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Horse.class)
public abstract class HorseMixin {
    @Redirect(method = {"getBreedOffspring", "finalizeSpawn"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Variant;values()[Lnet/minecraft/world/entity/animal/horse/Variant;"))
    private Variant[] redirectVariant() {
        return Values.HORSE_VARIANTS;
    }
    @Redirect(method = {"getBreedOffspring", "finalizeSpawn"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Markings;values()[Lnet/minecraft/world/entity/animal/horse/Markings;"))
    private Markings[] redirectMarkings() {
        return Values.HORSE_MARKINGS;
    }
}
