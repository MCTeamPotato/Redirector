package com.teampotato.redirectionor.mixin.minecraft.client.renderer.block.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.math.Vector3f;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Map;

@Mixin(ItemModelGenerator.class)
public abstract class MixinItemModelGenerator {
    @Shadow protected abstract List<BlockElement> createSideElements(TextureAtlasSprite pSprite, String pTexture, int pTintIndex);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public List<BlockElement> processFrames(int pTintIndex, String pTexture, TextureAtlasSprite pSprite) {
        Map<Direction, BlockElementFace> map = Maps.newHashMap();
        map.put(Redirectionor.SOUTH, new BlockElementFace(null, pTintIndex, pTexture, new BlockFaceUV(new float[]{0.0F, 0.0F, 16.0F, 16.0F}, 0)));
        map.put(Redirectionor.NORTH, new BlockElementFace(null, pTintIndex, pTexture, new BlockFaceUV(new float[]{16.0F, 0.0F, 0.0F, 16.0F}, 0)));
        List<BlockElement> list = Lists.newArrayList();
        list.add(new BlockElement(new Vector3f(0.0F, 0.0F, 7.5F), new Vector3f(16.0F, 16.0F, 8.5F), map, null, true));
        list.addAll(this.createSideElements(pSprite, pTexture, pTintIndex));
        return list;
    }
}
