package com.teampotato.redirectionor.mixin.client.gui.screens.inventory;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screens.inventory.CommandBlockEditScreen;
import net.minecraft.world.level.block.entity.CommandBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CommandBlockEditScreen.class)
public abstract class CommandBlockEditScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/CommandBlockEntity$Mode;values()[Lnet/minecraft/world/level/block/entity/CommandBlockEntity$Mode;"))
    private CommandBlockEntity.Mode[] redirectCommandBlockEntityMode() {
        return Redirectionor.COMMAND_BLOCK_ENTITY_MODES;
    }
}
