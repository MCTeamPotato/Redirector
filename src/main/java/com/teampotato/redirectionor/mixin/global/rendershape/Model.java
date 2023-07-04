package com.teampotato.redirectionor.mixin.global.rendershape;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({AbstractFurnaceBlock.class, BarrelBlock.class, BeaconBlock.class, BeehiveBlock.class, BellBlock.class, BrewingStandBlock.class, CampfireBlock.class, CommandBlock.class, DaylightDetectorBlock.class, EnchantmentTableBlock.class, FlowerPotBlock.class, GrindstoneBlock.class, HopperBlock.class, JukeboxBlock.class, LecternBlock.class, SculkCatalystBlock.class, SculkSensorBlock.class, SculkShriekerBlock.class, SpawnerBlock.class, StonecutterBlock.class, StructureBlock.class, BlockBehaviour.class})
public abstract class Model {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public RenderShape getRenderShape(BlockState pState) {
        return Redirectionor.MODEL;
    }
}
