package com.teampotato.redirectionor.mixin.minecraft.test;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.test.TestCommand;
import net.minecraft.util.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TestCommand.class)
public abstract class MixinTestCommand {
    @Redirect(method = "createNewStructure", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private static Rotation implNone() {
        return Redirectionor.NONE;
    }
}
