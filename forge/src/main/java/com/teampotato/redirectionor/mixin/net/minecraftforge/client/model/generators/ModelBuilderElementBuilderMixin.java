package com.teampotato.redirectionor.mixin.net.minecraftforge.client.model.generators;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraftforge.client.model.generators.ModelBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.BiConsumer;

@SuppressWarnings("rawtypes")
@Mixin(value = ModelBuilder.ElementBuilder.class, remap = false)
public abstract class ModelBuilderElementBuilderMixin {
    @Shadow public abstract ModelBuilder.ElementBuilder.FaceBuilder face(Direction dir);
    /**
     * @author Kasualix
     * @reason avoid stream and allocation
     */
    @Overwrite
    public ModelBuilder.ElementBuilder allFaces(BiConsumer<Direction, ModelBuilder.ElementBuilder.FaceBuilder> action) {
        for (Direction d : Redirectionor.DIRECTIONS) {
            action.accept(d, face(d));
        }
        return (ModelBuilder.ElementBuilder)(Object)this;
    }
}
