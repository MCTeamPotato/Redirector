package com.teampotato.redirector.mixin.com.mojang.realmsclient.gui;

import com.mojang.realmsclient.gui.RealmsDataFetcher;
import com.teampotato.redirector.redirect.ClientValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RealmsDataFetcher.class)
public abstract class RealmsDataFetcherMixin {
    @Redirect(method = "scheduleTasks", at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/gui/RealmsDataFetcher$Task;values()[Lcom/mojang/realmsclient/gui/RealmsDataFetcher$Task;"))
    private RealmsDataFetcher.Task[] redirectTasks() {
        return ClientValues.TASKS;
    }
}
