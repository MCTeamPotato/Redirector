package com.teampotato.redirectionor.mixin.net.minecraft.client.renderer.block.model;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.renderer.block.model.BlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(BlockModel.GuiLight.class)
public abstract class GuiLightMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static BlockModel.GuiLight getByName(String name) {
        return GUI_LIGHT_NAME_MAP.get(name);
    }

    @Unique
    private static final Map<String, BlockModel.GuiLight> GUI_LIGHT_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        GUI_LIGHT_NAME_MAP.put("side", BlockModel.GuiLight.SIDE);
        GUI_LIGHT_NAME_MAP.put("front", BlockModel.GuiLight.FRONT);
    }
}
