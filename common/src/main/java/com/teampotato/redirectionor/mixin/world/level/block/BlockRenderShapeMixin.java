package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class BlockRenderShapeMixin {
    @Mixin({AbstractFurnaceBlock.class, BarrelBlock.class, BeaconBlock.class, BeehiveBlock.class, BellBlock.class, BrewingStandBlock.class, CampfireBlock.class, CommandBlock.class, DaylightDetectorBlock.class, DispenserBlock.class, EnchantmentTableBlock.class, FlowerPotBlock.class, GrindstoneBlock.class, HopperBlock.class, JukeboxBlock.class, LecternBlock.class, SpawnerBlock.class, StonecutterBlock.class, StructureBlock.class, BlockBehaviour.class})
    public abstract static class Model {
        @Redirect(method = "getRenderShape", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;MODEL:Lnet/minecraft/world/level/block/RenderShape;"))
        private RenderShape redirectRenderShapeMODEL() {
            return RenderShapeReferences.MODEL;
        }
    }

    @Mixin({AirBlock.class, BarrierBlock.class, BaseEntityBlock.class, BubbleColumnBlock.class, LiquidBlock.class, StructureVoidBlock.class})
    public abstract static class Invisible {
        @Redirect(method = "getRenderShape", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
        private RenderShape redirectRenderShapeINVISIBLE() {
            return RenderShapeReferences.INVISIBLE;
        }
    }

    @Mixin({BedBlock.class, ChestBlock.class, ConduitBlock.class, EnderChestBlock.class, ShulkerBoxBlock.class})
    public abstract static class EntityBlockAnimated {
        @Redirect(method = "getRenderShape", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;ENTITYBLOCK_ANIMATED:Lnet/minecraft/world/level/block/RenderShape;"))
        private RenderShape redirectRenderShapeENTITYBLOCK_ANIMATED() {
            return RenderShapeReferences.ENTITYBLOCK_ANIMATED;
        }
    }
}
