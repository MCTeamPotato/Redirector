package com.teampotato.redirector.mixin.net.minecraft.client.renderer.block.model;

import com.teampotato.redirector.utils.map.ClientMaps;
import net.minecraft.client.renderer.block.model.BlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockModel.GuiLight.class)
public abstract class BlockModelGuiLightMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static BlockModel.GuiLight getByName(String name) {
        return ClientMaps.GUI_LIGHT_NAME_MAP.get(name);
    }
}
