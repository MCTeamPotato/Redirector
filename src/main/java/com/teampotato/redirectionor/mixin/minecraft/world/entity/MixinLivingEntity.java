package com.teampotato.redirectionor.mixin.minecraft.world.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {
    public MixinLivingEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Shadow public abstract Optional<BlockPos> getSleepingPos();

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @Nullable
    public Direction getBedOrientation() {
        BlockPos blockpos = this.getSleepingPos().orElse(null);
        if (blockpos == null) return Redirectionor.UP;
        BlockState state = this.level.getBlockState(blockpos);
        return !state.isBed(level, blockpos, (LivingEntity)(Object)this) ? Redirectionor.UP : state.getBedDirection(level, blockpos);
    }
}
