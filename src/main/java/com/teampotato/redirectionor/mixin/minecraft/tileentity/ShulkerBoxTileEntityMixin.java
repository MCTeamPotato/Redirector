package com.teampotato.redirectionor.mixin.minecraft.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = ShulkerBoxTileEntity.class, priority = 10)
public abstract class ShulkerBoxTileEntityMixin extends LockableLootTileEntity {
    protected ShulkerBoxTileEntityMixin(TileEntityType<?> p_i48284_1_) {
        super(p_i48284_1_);
    }
    @Shadow protected abstract AxisAlignedBB getTopBoundingBox(Direction p_190588_1_);
    @Redirect(method = "createUnSidedHandler", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implUp() {
        return Redirectionor.UP;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void moveCollidedEntities() {
        if (level == null) return;
        BlockState blockstate = level.getBlockState(this.getBlockPos());
        if (blockstate.getBlock() instanceof ShulkerBoxBlock) {
            Direction direction = blockstate.getValue(ShulkerBoxBlock.FACING);
            AxisAlignedBB axisalignedbb = this.getTopBoundingBox(direction).move(this.worldPosition);
            List<Entity> list = this.level.getEntities(null, axisalignedbb);
            if (!list.isEmpty()) {
                for (Entity entity : list) {
                    if (entity.getPistonPushReaction() != PushReaction.IGNORE) {
                        double d0 = 0.0D;
                        double d1 = 0.0D;
                        double d2 = 0.0D;
                        AxisAlignedBB axisalignedbb1 = entity.getBoundingBox();
                        switch (direction.getAxis()) {
                            case X:
                                if (direction.getAxisDirection() == Redirectionor.POSITIVE) {
                                    d0 = axisalignedbb.maxX - axisalignedbb1.minX;
                                } else {
                                    d0 = axisalignedbb1.maxX - axisalignedbb.minX;
                                }

                                d0 = d0 + 0.01D;
                                break;
                            case Y:
                                if (direction.getAxisDirection() == Redirectionor.POSITIVE) {
                                    d1 = axisalignedbb.maxY - axisalignedbb1.minY;
                                } else {
                                    d1 = axisalignedbb1.maxY - axisalignedbb.minY;
                                }

                                d1 = d1 + 0.01D;
                                break;
                            case Z:
                                if (direction.getAxisDirection() == Redirectionor.POSITIVE) {
                                    d2 = axisalignedbb.maxZ - axisalignedbb1.minZ;
                                } else {
                                    d2 = axisalignedbb1.maxZ - axisalignedbb.minZ;
                                }

                                d2 = d2 + 0.01D;
                        }

                        entity.move(MoverType.SHULKER_BOX, new Vector3d(d0 * (double) direction.getStepX(), d1 * (double) direction.getStepY(), d2 * (double) direction.getStepZ()));
                    }
                }

            }
        }
    }
}
