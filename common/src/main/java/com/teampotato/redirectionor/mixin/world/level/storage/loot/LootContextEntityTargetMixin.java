package com.teampotato.redirectionor.mixin.world.level.storage.loot;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LootContext.EntityTarget.class)
public abstract class LootContextEntityTargetMixin {
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/LootContext$EntityTarget;values()[Lnet/minecraft/world/level/storage/loot/LootContext$EntityTarget;"))
    private static LootContext.EntityTarget[] redirectLootContextEntityTarget() {
        return Redirectionor.LOOT_CONTEXT_ENTITY_TARGETS;
    }
}
