package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.animal;

import net.minecraft.world.entity.animal.Panda;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Panda.Gene.class)
public abstract class PandaGeneMixin {
    @Unique
  private static final Panda.Gene[] PANDA_GENES = Panda.Gene.values();
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Panda$Gene;values()[Lnet/minecraft/world/entity/animal/Panda$Gene;"))
    private static Panda.Gene[] redirectPandaGene() {
        return PANDA_GENES;
    }
}
