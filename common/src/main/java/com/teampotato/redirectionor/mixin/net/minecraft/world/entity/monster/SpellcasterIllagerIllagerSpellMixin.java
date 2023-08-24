package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.monster;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(SpellcasterIllager.IllagerSpell.class)
public class SpellcasterIllagerIllagerSpellMixin {
    @Unique private static final SpellcasterIllager.IllagerSpell[] ILLAGER_SPELLS = SpellcasterIllager.IllagerSpell.values();
    @Redirect(method = "byId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/SpellcasterIllager$IllagerSpell;values()[Lnet/minecraft/world/entity/monster/SpellcasterIllager$IllagerSpell;"))
    private static SpellcasterIllager.IllagerSpell[] rediectIllagerSpell() {
        return ILLAGER_SPELLS;
    }


    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static SpellcasterIllager.IllagerSpell byId(int id) {
        SpellcasterIllager.IllagerSpell illagerSpell = ILLAGER_SPELL_ID_MAP.get(id);
        if (illagerSpell == null) return SpellcasterIllager.IllagerSpell.NONE;
        return illagerSpell;
    }
    @Unique
    private static final Map<Integer, SpellcasterIllager.IllagerSpell> ILLAGER_SPELL_ID_MAP = new Int2ObjectOpenHashMap<>();

    static {
        for (SpellcasterIllager.IllagerSpell illagerSpell : SpellcasterIllager.IllagerSpell.values()) {
            ILLAGER_SPELL_ID_MAP.put(illagerSpell.id, illagerSpell);
        }
    }
}
