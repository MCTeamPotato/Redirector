package com.teampotato.redirectionor.mixin.minecraft.test;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.test.TestUtils;
import net.minecraft.util.Mirror;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TestUtils.class)
public abstract class MixinTestUtils {
    @Redirect(method = {"spawnBeacon", "spawnLectern"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
    private static Mirror implMirrorNone() {
        return Redirectionor.MIRROR_NONE;
    }
}
