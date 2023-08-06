package com.teampotato.redirectionor.mixin.world.entity.animal;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.entity.animal.Panda;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Panda.Gene.class)
public abstract class PandaGeneMixin {
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Panda$Gene;values()[Lnet/minecraft/world/entity/animal/Panda$Gene;"))
    private static Panda.Gene[] redirectPandaGene() {
        return Redirectionor.PANDA_GENES;
    }
}
