package com.teampotato.redirectionor.mixin.minecraft.command.arguments;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.command.arguments.SwizzleArgument;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SwizzleArgument.class)
public abstract class SwizzleArgumentMixin {
    @Redirect(method = "parse(Lcom/mojang/brigadier/StringReader;)Ljava/util/EnumSet;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }
}
