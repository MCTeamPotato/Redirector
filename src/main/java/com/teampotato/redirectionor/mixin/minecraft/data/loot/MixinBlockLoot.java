package com.teampotato.redirectionor.mixin.minecraft.data.loot;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;

@Mixin(BlockLoot.class)
public abstract class MixinBlockLoot {
    @Shadow protected abstract void add(Block p_124176_, Function<Block, LootTable.Builder> p_124177_);

    @Shadow protected static <T extends Comparable<T> & StringRepresentable> LootTable.Builder createSinglePropConditionTable(Block p_124162_, Property<T> p_124163_, T p_124164_) {
        throw new RuntimeException();
    }

    @Redirect(method = "createMultifaceBlockDrops", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] implValues1() {
        return Redirectionor.DIRECTIONS;
    }
}
