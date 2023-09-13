package com.teampotato.redirector.mixin.net.minecraft.world.entity.ai.goal;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.BegGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BegGoal.class)
public abstract class BegGoalMixin {
    @Redirect(method = "playerHoldingInteresting", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionHand;values()[Lnet/minecraft/world/InteractionHand;"))
    private InteractionHand[] redirectInteractionHands() {
        return CommonValues.INTERACTION_HANDS;
    }
}
