package com.teampotato.redirectionor.mixin.net.minecraft.world.level.block.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(JigsawBlockEntity.JointType.class)
public abstract class JigsawBlockEntityJointTypeMixin {
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/JigsawBlockEntity$JointType;values()[Lnet/minecraft/world/level/block/entity/JigsawBlockEntity$JointType;"))
    private static JigsawBlockEntity.JointType[] redirectJigsawBlockEntityJointType() {
        return Redirectionor.JIGSAW_BLOCK_ENTITY_JOINT_TYPES;
    }
}
