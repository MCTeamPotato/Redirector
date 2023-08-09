package com.teampotato.redirectionor.mixin.world.level.block.entity;

import com.teampotato.redirectionor.common.Maps;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Optional;

@Mixin(JigsawBlockEntity.JointType.class)
public abstract class JigsawBlockEntityJointTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static Optional<JigsawBlockEntity.JointType> byName(String string) {
        return Optional.ofNullable(Maps.STRING_JOINT_TYPE_MAP.get(string));
    }
}
