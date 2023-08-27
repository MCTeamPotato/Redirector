package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.ai.goal;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.BegGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BegGoal.class)
public abstract class BegGoalMixin {
    @Redirect(method = "playerHoldingInteresting", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionHand;values()[Lnet/minecraft/world/InteractionHand;"))
    private InteractionHand[] redirectInteractionHand() {
        return Redirectionor.INTERACTION_HANDS;
    }

}
