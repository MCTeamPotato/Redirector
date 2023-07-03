package com.teampotato.redirectionor.mixin.global.north;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("UnstableApiUsage")
@Mixin(value = {BrewingStandBlockEntity.class, AbstractFurnaceBlockEntity.class}, remap = false)
public abstract class InReviveCaps extends CapabilityProvider<BlockEntity> implements WorldlyContainer{
    @Shadow LazyOptional<? extends IItemHandler>[] handlers;

    protected InReviveCaps(Class<BlockEntity> baseClass) {
        super(baseClass);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.handlers = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Redirectionor.UP, Redirectionor.DOWN, Redirectionor.NORTH);
    }
}
