package com.teampotato.redirectionor.mixin.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VisGraph.class)
public abstract class VisGraphMixin {
    @Redirect(method = "addEdges", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
