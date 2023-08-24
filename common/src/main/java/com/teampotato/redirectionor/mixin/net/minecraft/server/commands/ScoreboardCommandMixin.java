package com.teampotato.redirectionor.mixin.net.minecraft.server.commands;

import net.minecraft.server.commands.ScoreboardCommand;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScoreboardCommand.class)
public abstract class ScoreboardCommandMixin {
    @Unique
  private static final ObjectiveCriteria.RenderType[] OBJECTIVE_CRITERIA_RENDER_TYPES = ObjectiveCriteria.RenderType.values();
    @Redirect(method = "createRenderTypeModify", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/scores/criteria/ObjectiveCriteria$RenderType;values()[Lnet/minecraft/world/scores/criteria/ObjectiveCriteria$RenderType;"))
    private static ObjectiveCriteria.RenderType[] redirectObjectiveCriteriaRenderType() {
        return OBJECTIVE_CRITERIA_RENDER_TYPES;
    }
}
