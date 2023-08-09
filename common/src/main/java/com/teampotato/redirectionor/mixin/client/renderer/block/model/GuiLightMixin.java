package com.teampotato.redirectionor.mixin.client.renderer.block.model;

import com.teampotato.redirectionor.client.ClientMaps;
import net.minecraft.client.renderer.block.model.BlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockModel.GuiLight.class)
public abstract class GuiLightMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static BlockModel.GuiLight getByName(String string) {
        return ClientMaps.STRING_GUI_LIGHT_MAP.get(string);
    }
}
