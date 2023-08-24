package com.teampotato.redirectionor.mixin.net.minecraft.client.gui.screens.inventory;

import net.minecraft.client.gui.screens.inventory.CommandBlockEditScreen;
import net.minecraft.world.level.block.entity.CommandBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CommandBlockEditScreen.class)
public abstract class CommandBlockEditScreenMixin {
    @Unique
    static final CommandBlockEntity.Mode[] COMMAND_BLOCK_ENTITY_MODES = CommandBlockEntity.Mode.values();
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/CommandBlockEntity$Mode;values()[Lnet/minecraft/world/level/block/entity/CommandBlockEntity$Mode;"))
    private CommandBlockEntity.Mode[] redirectCommandBlockEntityMode() {
        return COMMAND_BLOCK_ENTITY_MODES;
    }
}
