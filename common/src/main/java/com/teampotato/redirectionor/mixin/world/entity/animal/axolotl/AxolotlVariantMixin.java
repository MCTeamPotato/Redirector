package com.teampotato.redirectionor.mixin.world.entity.animal.axolotl;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Axolotl.Variant.class)
public class AxolotlVariantMixin {
    @Redirect(method = "getSpawnVariant", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/axolotl/Axolotl$Variant;values()[Lnet/minecraft/world/entity/animal/axolotl/Axolotl$Variant;"))
    private static Axolotl.Variant[] redirectAxolotlVariant() {

        return Redirectionor.AXOLOTL_VARIANTS;
    }
}
