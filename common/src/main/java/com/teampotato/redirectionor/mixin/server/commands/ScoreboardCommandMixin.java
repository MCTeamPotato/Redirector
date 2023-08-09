package com.teampotato.redirectionor.mixin.server.commands;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.server.commands.ScoreboardCommand;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScoreboardCommand.class)
public abstract class ScoreboardCommandMixin {
    @Redirect(method = "createRenderTypeModify", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/scores/criteria/ObjectiveCriteria$RenderType;values()[Lnet/minecraft/world/scores/criteria/ObjectiveCriteria$RenderType;"))
    private static ObjectiveCriteria.RenderType[] redirectObjectiveCriteriaRenderType() {
        return Values.OBJECTIVE_CRITERIA_RENDER_TYPES;
    }
}
