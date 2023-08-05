package com.teampotato.redirectionor.mixin.world.level.chunk.storage;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.chunk.storage.IOWorker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IOWorker.class)
public abstract class IOWorkerMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;values()[Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;"))
    private IOWorker.Priority[] redirectIOWorkerPriority() {
        return Redirectionor.PRIORITIES;
    }
}
