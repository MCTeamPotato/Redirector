package com.teampotato.redirectionor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class RedirectionorMixinPlugin implements IMixinConfigPlugin {
    private static final Logger LOGGER = LogManager.getLogger();

    public RedirectionorMixinPlugin() {
        LOGGER.warn("Redirectionor is going to load.");
        LOGGER.warn("It is possible that you will see some mixin applying failures during the game loading.");
        LOGGER.warn("But you don't really need to care much about them as it is normal behavior for the best compatibility.");
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public void onLoad(String mixinPackage) {}
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
