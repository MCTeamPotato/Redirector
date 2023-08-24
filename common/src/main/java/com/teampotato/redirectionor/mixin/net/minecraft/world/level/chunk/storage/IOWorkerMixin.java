package com.teampotato.redirectionor.mixin.net.minecraft.world.level.chunk.storage;

import net.minecraft.world.level.chunk.storage.IOWorker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IOWorker.class)
public abstract class IOWorkerMixin {
    @Unique
  private static final IOWorker.Priority[] redirectionor$PRIORITIES = IOWorker.Priority.values();
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;values()[Lnet/minecraft/world/level/chunk/storage/IOWorker$Priority;"))
    private IOWorker.Priority[] redirectIOWorkerPriority() {
        return redirectionor$PRIORITIES;
    }
}
