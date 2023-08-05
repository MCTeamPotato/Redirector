package com.teampotato.redirectionor.mixin.world.entity.monster;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpellcasterIllager.IllagerSpell.class)
public class SpellcasterIllagerIllagerSpellMixin {
    @Redirect(method = "byId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/SpellcasterIllager$IllagerSpell;values()[Lnet/minecraft/world/entity/monster/SpellcasterIllager$IllagerSpell;"))
    private static SpellcasterIllager.IllagerSpell[] rediectIllagerSpell() {
        return Redirectionor.ILLAGER_SPELLS;
    }
}
