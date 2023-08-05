package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MineshaftStructure.Type.class)
public abstract class MineshaftStructureTypeMixin {
    @Redirect(method = "byId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/structure/structures/MineshaftStructure$Type;values()[Lnet/minecraft/world/level/levelgen/structure/structures/MineshaftStructure$Type;"))
    private static MineshaftStructure.Type[] redirectMineshaftStructureType() {
        return Redirectionor.MINESHAFT_STRUCTURE_TYPES;
    }

}
