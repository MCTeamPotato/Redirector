package com.teampotato.redirectionor.mixin.gametest.framework;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.gametest.framework.TestCommand;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TestCommand.class)
public abstract class TestCommandMixin {
    @Redirect(method = "createNewStructure", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }
}
