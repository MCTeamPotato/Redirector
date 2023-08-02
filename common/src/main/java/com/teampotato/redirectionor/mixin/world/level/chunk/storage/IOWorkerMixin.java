package com.teampotato.redirectionor.mixin.world.level.chunk.storage;

import com.teampotato.redirectionor.references.PriorityReferences;
import net.minecraft.world.level.chunk.storage.IOWorker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IOWorker.class)
public abstract class IOWorkerMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;values()[Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;"))
    private IOWorker.Priority[] redirectPriorityValues() {
        return PriorityReferences.PRIORITIES;
    }

    @Redirect(method = "method_27938", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;ordinal()I"))
    private static int redirectPriorityOrdinalStatic(IOWorker.Priority instance) {
        return PriorityReferences.OrdinalReferences.ORDINAL_MAP.getInt(instance);
    }

    @Redirect(method = {"method_27941", "tellStorePending"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;ordinal()I"))
    private int redirectPriorityOrdinal(IOWorker.Priority instance) {
        return PriorityReferences.OrdinalReferences.ORDINAL_MAP.getInt(instance);
    }
}
