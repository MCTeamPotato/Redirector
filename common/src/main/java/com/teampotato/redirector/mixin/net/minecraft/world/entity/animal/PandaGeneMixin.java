package com.teampotato.redirector.mixin.net.minecraft.world.entity.animal;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.entity.animal.Panda;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Panda.Gene.class)
public abstract class PandaGeneMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static Panda.Gene byName(String name) {
        return CommonMaps.PANDA_GENE_NAME_MAP.getOrDefault(name, Panda.Gene.NORMAL);
    }
}
