package com.teampotato.redirectionor.mixin.gametest.framework;

import com.teampotato.redirectionor.references.MirrorReferences;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.block.Mirror;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameTestHelper.class)
public abstract class GameTestHelperMixin {
    @Redirect(method = {"absolutePos", "relativePos", "absoluteVec"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Mirror;NONE:Lnet/minecraft/world/level/block/Mirror;"))
    private Mirror redirectMirrorNONE() {
        return MirrorReferences.NONE;
    }
}
