package com.teampotato.redirector.mixin.net.minecraft.world.entity.monster;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SpellcasterIllager.IllagerSpell.class)
public abstract class SpellcasterIllagerIllagerSpellMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static SpellcasterIllager.IllagerSpell byId(int id) {
        return CommonMaps.ILLAGER_SPELL_ID_MAP.getOrDefault(id, SpellcasterIllager.IllagerSpell.NONE);
    }
}
