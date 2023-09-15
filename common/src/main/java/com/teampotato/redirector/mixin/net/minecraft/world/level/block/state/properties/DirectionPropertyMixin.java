package com.teampotato.redirector.mixin.net.minecraft.world.level.block.state.properties;

import com.teampotato.redirector.utils.Utils;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.function.Predicate;

@Mixin(DirectionProperty.class)
public abstract class DirectionPropertyMixin {
    /**
     * @author Kasualix
     * @reason avoid stream and {@link Direction#values()} allocation
     */
    @Overwrite
    public static @NotNull DirectionProperty create(String name, Predicate<Direction> filter) {
        return Utils.create(name, filter);
    }

}
