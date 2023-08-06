package com.teampotato.redirectionor.mixin;

import com.teampotato.redirectionor.config.Option;
import com.teampotato.redirectionor.config.RedirectionorMixinConfig;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.io.File;
import java.util.List;
import java.util.Set;

import static com.teampotato.redirectionor.config.RedirectionorMixinConfig.LOGGER;

public class RedirectionorMixinPlugin implements IMixinConfigPlugin {
    private static final String MIXIN_PACKAGE_ROOT = "com.teampotato.redirectionor.mixin.";
    public static RedirectionorMixinConfig config;
    public static RedirectionorMixinPlugin instance;

    public RedirectionorMixinPlugin() {
        instance = this;
        this.onLoad(MIXIN_PACKAGE_ROOT);
        LOGGER.info("Loaded configuration file for Redirectionor: {} options available, {} override(s) found", config.getOptionCount(), config.getOptionOverrideCount());
        LOGGER.warn("Redirectionor is going to load.");
        LOGGER.warn("It's possible that you will see some mixin applying failures or skipping in this log");
        LOGGER.warn("But you don't really need to care much about them as they're normal things existing for the best compatibility.");
        LOGGER.warn("If you encounter any problem, report it in my issue tracker: https://github.com/MCTeamPotato/Kasualix-Issue-Tracker/issues");
    }

    @Override
    public void onLoad(String mixinPackage) {
        try {
            config = RedirectionorMixinConfig.load(new File("./config/redirectionor-mixins.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Could not load configuration file for Redirectionor", e);
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (!mixinClassName.startsWith(MIXIN_PACKAGE_ROOT)) {
            LOGGER.error("Expected mixin '{}' to start with package root '{}', treating as foreign and " + "disabling!", mixinClassName, MIXIN_PACKAGE_ROOT);
            return false;
        }

        String mixin = mixinClassName.substring(MIXIN_PACKAGE_ROOT.length());
        Option option = config.getEffectiveOptionForMixin(mixin);
        if (option == null) {
            LOGGER.error("No rules matched mixin '{}', treating as foreign and disabling!", mixin);
            return false;
        }

        if (option.isOverridden()) {
            String source = "[unknown]";
            if (option.isUserDefined()) {
                source = "user configuration";
            } else if (option.isModDefined()) {
                source = "mods [" + String.join(", ", option.getDefiningMods()) + "]";
            }
            if (option.isEnabled()) {
                LOGGER.warn("Force-enabling mixin '{}' as rule '{}' (added by {}) enables it", mixin, option.getName(), source);
            } else {
                LOGGER.warn("Force-disabling mixin '{}' as rule '{}' (added by {}) disables it and children", mixin, option.getName(), source);
            }
        }
        return option.isEnabled();
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {return null;}

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
