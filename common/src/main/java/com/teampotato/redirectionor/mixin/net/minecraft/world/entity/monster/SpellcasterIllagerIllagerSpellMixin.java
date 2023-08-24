package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.monster;

import net.minecraft.world.entity.monster.SpellcasterIllager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpellcasterIllager.IllagerSpell.class)
public class SpellcasterIllagerIllagerSpellMixin {
    @Unique
  private static final SpellcasterIllager.IllagerSpell[] ILLAGER_SPELLS = SpellcasterIllager.IllagerSpell.values();
    @Redirect(method = "byId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/SpellcasterIllager$IllagerSpell;values()[Lnet/minecraft/world/entity/monster/SpellcasterIllager$IllagerSpell;"))
    private static SpellcasterIllager.IllagerSpell[] rediectIllagerSpell() {
        return ILLAGER_SPELLS;
    }
}
