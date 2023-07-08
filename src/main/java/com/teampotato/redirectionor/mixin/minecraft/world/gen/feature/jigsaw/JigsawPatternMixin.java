package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.jigsaw;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(value = JigsawPattern.class, priority = 0)
public abstract class JigsawPatternMixin {
    @Shadow private int maxSize;

    @Shadow @Final private List<JigsawPiece> templates;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public int getMaxSize(TemplateManager pTemplateManager) {
        if (this.maxSize == Integer.MIN_VALUE) {
            this.maxSize = this.templates.stream()
                    .mapToInt((p_236856_1_) -> p_236856_1_.getBoundingBox(pTemplateManager, BlockPos.ZERO, Redirectionor.NONE).getYSpan())
                    .max()
                    .orElse(0);
        }
        return this.maxSize;
    }
}
