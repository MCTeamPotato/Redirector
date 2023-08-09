package com.teampotato.redirectionor.mixin.world.entity.animal.horse;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.animal.horse.Llama;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Llama.class)
public abstract class LlamaMixin {
    @Redirect(method = "finalizeSpawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Llama$Variant;values()[Lnet/minecraft/world/entity/animal/horse/Llama$Variant;"))
    private Llama.Variant[] redirectLlamaVariant() {
        return Values.LLAMA_VARIANTS;
    }
}
