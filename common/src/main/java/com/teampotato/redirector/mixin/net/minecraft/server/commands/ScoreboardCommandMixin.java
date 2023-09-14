package com.teampotato.redirector.mixin.net.minecraft.server.commands;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.commands.ScoreboardCommand;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScoreboardCommand.class)
public abstract class ScoreboardCommandMixin {
    @Redirect(method = "createRenderTypeModify", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/scores/criteria/ObjectiveCriteria$RenderType;values()[Lnet/minecraft/world/scores/criteria/ObjectiveCriteria$RenderType;"))
    private static ObjectiveCriteria.RenderType[] redirectObjectiveCriteriaRenderTypes() {
        return CommonValues.OBJECTIVE_CRITERIA_RENDER_TYPES;
    }
}