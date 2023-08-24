package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.animal;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.entity.animal.Panda;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Map;

@Mixin(Panda.Gene.class)
public abstract class PandaGeneMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static Panda.Gene byName(String name) {
        Panda.Gene gene = GENE_NAME_MAP.get(name);
        if (gene == null) return Panda.Gene.NORMAL;
        return gene;
    }

    private static final Map<String, Panda.Gene> GENE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (Panda.Gene gene : Panda.Gene.values()) {
            GENE_NAME_MAP.put(gene.getName(), gene);
        }
    }
}
