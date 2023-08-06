package com.teampotato.redirectionor.mixin.world;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Difficulty.class)
public abstract class DifficultyMixin {
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Difficulty;values()[Lnet/minecraft/world/Difficulty;"))
    private static Difficulty[] redirectDifficulty() {
        return Redirectionor.DIFFICULTIES;
    }
}
