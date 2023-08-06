package com.teampotato.redirectionor.mixin.client.gui.screens.inventory;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screens.inventory.JigsawBlockEditScreen;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(JigsawBlockEditScreen.class)
public abstract class JigsawBlockEditScreenMixin {
    @Redirect(method = "method_26411", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/JigsawBlockEntity$JointType;values()[Lnet/minecraft/world/level/block/entity/JigsawBlockEntity$JointType;"))
    private JigsawBlockEntity.JointType[] redirectJigsawBlockEntityJointType() {
        return Redirectionor.JIGSAW_BLOCK_ENTITY_JOINT_TYPES;
    }
}
