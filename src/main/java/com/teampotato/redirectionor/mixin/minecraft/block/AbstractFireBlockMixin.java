package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PortalSize;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;

@Mixin(value = AbstractFireBlock.class, priority = 10)
public abstract class AbstractFireBlockMixin {
    @Shadow
    private static boolean inPortalDimension(World pLevel) {
        throw new RuntimeException();
    }

    @Redirect(method = "isPortal", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void onPlace(BlockState pState, World pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pOldState.is(pState.getBlock())) {
            if (inPortalDimension(pLevel)) {
                Optional<PortalSize> optional = PortalSize.findEmptyPortalShape(pLevel, pPos, Redirectionor.X);
                optional =  net.minecraftforge.event.ForgeEventFactory.onTrySpawnPortal(pLevel, pPos, optional);
                if (optional.isPresent()) {
                    optional.get().createPortalBlocks();
                    return;
                }
            }

            if (!pState.canSurvive(pLevel, pPos)) pLevel.removeBlock(pPos, false);
        }
    }
}
