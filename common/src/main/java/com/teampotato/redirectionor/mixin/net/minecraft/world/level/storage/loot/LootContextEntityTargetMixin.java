package com.teampotato.redirectionor.mixin.net.minecraft.world.level.storage.loot;

import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LootContext.EntityTarget.class)
public abstract class LootContextEntityTargetMixin {
    @Unique
    static final LootContext.EntityTarget[] LOOT_CONTEXT_ENTITY_TARGETS = LootContext.EntityTarget.values();
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/LootContext$EntityTarget;values()[Lnet/minecraft/world/level/storage/loot/LootContext$EntityTarget;"))
    private static LootContext.EntityTarget[] redirectLootContextEntityTarget() {
        return LOOT_CONTEXT_ENTITY_TARGETS;
    }
}
