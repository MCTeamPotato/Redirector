package com.teampotato.redirectionor.config;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("CanBeFinal")
public class RedirectionorMixinConfig {
    public static final Logger LOGGER = LogManager.getLogger("Redirectionor");
    private final Map<String, Option> options = new HashMap<>();
    public RedirectionorMixinConfig() {
        this.addMixinRule("com.mojang", true);
        this.addMixinRule("com.mojang.blaze3d.platform", true);
        this.addMixinRule("com.mojang.math", true);
        this.addMixinRule("com.mojang.realmsclient", true);
        this.addMixinRule("com.mojang.realmsclient.client", true);
        this.addMixinRule("com.mojang.realmsclient.gui.screens", true);
        this.addMixinRule("net.minecraft.advancements", true);
        this.addMixinRule("net.minecraft", true);
        this.addMixinRule("net.minecraft.chat", true);
        this.addMixinRule("net.minecraft.client", true);
        this.addMixinRule("net.minecraft.client.gui", true);
        this.addMixinRule("net.minecraft.client.gui.components", true);
        this.addMixinRule("net.minecraft.client.gui.screens", true);
        this.addMixinRule("net.minecraft.client.gui.screens.advancements", true);
        this.addMixinRule("net.minecraft.client.gui.screens.inventory", true);
        this.addMixinRule("net.minecraft.client.gui.screens.reporting", true);
        this.addMixinRule("net.minecraft.client.gui.screens.worldselection", true);
        this.addMixinRule("net.minecraft.client.model.geom", true);
        this.addMixinRule("net.minecraft.client.multiplayer", true);
        this.addMixinRule("net.minecraft.client.multiplayer.chat.report", true);
        this.addMixinRule("net.minecraft.client.renderer", true);
        this.addMixinRule("net.minecraft.client.renderer.block.model", true);
        this.addMixinRule("net.minecraft.client.renderer.chunk", true);
        this.addMixinRule("net.minecraft.client.renderer.entity", true);
        this.addMixinRule("net.minecraft.client.renderer.entity.layers", true);
        this.addMixinRule("net.minecraft.client.resources", true);
        this.addMixinRule("net.minecraft.client.resources.model", true);
        this.addMixinRule("net.minecraft.client.resources.sounds", true);
        this.addMixinRule("net.minecraft.client.resources.tutorial", true);
        this.addMixinRule("net.minecraft.commands.arguments.selector.options", true);
        this.addMixinRule("net.minecraft.compat", true);
        this.addMixinRule("net.minecraft.compat.modernfix", isNotLoaded("modernfix"));
        this.addMixinRule("net.minecraft.compat.lithium", isNotLoaded("lithium") && isNotLoaded("roadrunner") && isNotLoaded("canary"));
        this.addMixinRule("net.minecraft.compat.nicerportals", isNotLoaded("nicerportals"));
        this.addMixinRule("net.minecraft.compat.sodium", isNotLoaded("sodium") && isNotLoaded("rubidium") && isNotLoaded("magnesium") && isNotLoaded("chlorine"));
        this.addMixinRule("net.minecraft.core", true);
        this.addMixinRule("net.minecraft.data", true);
        this.addMixinRule("net.minecraft.data.loot", true);
        this.addMixinRule("net.minecraft.data.model", true);
        this.addMixinRule("net.minecraft.network.protocol.game", true);
        this.addMixinRule("net.minecraft.server", true);
        this.addMixinRule("net.minecraft.server.commands", true);
        this.addMixinRule("net.minecraft.server.level", true);
        this.addMixinRule("net.minecraft.server.packs", true);
        this.addMixinRule("net.minecraft.util", true);
        this.addMixinRule("net.minecraft.world", true);
        this.addMixinRule("net.minecraft.world.entity", true);
        this.addMixinRule("net.minecraft.world.entity.ai", true);
        this.addMixinRule("net.minecraft.world.entity.ai.behavior", true);
        this.addMixinRule("net.minecraft.world.entity.ai.goal", true);
        this.addMixinRule("net.minecraft.world.entity.animal", true);
        this.addMixinRule("net.minecraft.world.entity.monster", true);
        this.addMixinRule("net.minecraft.world.entity.projectile", true);
        this.addMixinRule("net.minecraft.world.item", true);
        this.addMixinRule("net.minecraft.world.level", true);
        this.addMixinRule("net.minecraft.world.level.block", true);
        this.addMixinRule("net.minecraft.world.level.block.entity", true);
        this.addMixinRule("net.minecraft.world.level.block.state.pattern", true);
        this.addMixinRule("net.minecraft.world.level.chunk", true);
        this.addMixinRule("net.minecraft.world.level.chunk.storage", true);
        this.addMixinRule("net.minecraft.world.level.gameevent.vibrations", true);
        this.addMixinRule("net.minecraft.world.level.levelgen", true);
        this.addMixinRule("net.minecraft.world.level.levelgen.blending", true);
        this.addMixinRule("net.minecraft.world.level.levelgen.feature", true);
        this.addMixinRule("net.minecraft.world.level.levelgen.structure", true);
        this.addMixinRule("net.minecraft.world.level.levelgen.structure.structures", true);
        this.addMixinRule("net.minecraft.world.level.levelgen.structure.templatesystem", true);
        this.addMixinRule("net.minecraft.world.level.material", true);
        this.addMixinRule("net.minecraft.world.level.pathfinder", true);
        this.addMixinRule("net.minecraft.world.level.saveddata.maps", true);
        this.addMixinRule("net.minecraft.world.level.storage.loot", true);
        this.addMixinRule("net.minecraft.world.level.storage.loot.functions", true);
        this.addMixinRule("net.minecraft.world.ticks", true);
    }

    private static boolean isNotLoaded(String modID) {
        return !FabricLoader.getInstance().isModLoaded(modID);
    }

    private void addMixinRule(String mixin, boolean applicable) {
        String name = getMixinRuleName(mixin);

        if (this.options.putIfAbsent(name, new Option(name, applicable, false)) != null) throw new IllegalStateException("Mixin rule already defined: " + mixin);
    }

    private void readProperties(Properties props) {
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();

            Option option = this.options.get(key);

            if (option == null) {
                LOGGER.warn("No configuration key exists with name '{}', ignoring", key);
                continue;
            }

            boolean enabled;

            if (value.equalsIgnoreCase("true")) {
                enabled = true;
            } else if (value.equalsIgnoreCase("false")) {
                enabled = false;
            } else {
                LOGGER.warn("Invalid value '{}' encountered for configuration key '{}', ignoring", value, key);
                continue;
            }

            option.setEnabled(enabled, true);
        }
    }

    public Option getEffectiveOptionForMixin(String mixinClassName) {
        int lastSplit = 0;
        int nextSplit;

        Option rule = null;

        while ((nextSplit = mixinClassName.indexOf('.', lastSplit)) != -1) {
            String key = getMixinRuleName(mixinClassName.substring(0, nextSplit));

            Option candidate = this.options.get(key);

            if (candidate != null) {
                rule = candidate;

                if (!rule.isEnabled()) return rule;
            }

            lastSplit = nextSplit + 1;
        }

        return rule;
    }

    private void writeConfig(File file, Properties props) throws IOException {
        File dir = file.getParentFile();

        if (!dir.exists()) {
            if (!dir.mkdirs()) throw new IOException("Could not create parent directories");
        } else if (!dir.isDirectory()) {
            throw new IOException("The parent file is not a directory");
        }

        try (Writer writer = new FileWriter(file)) {
            writer.write("# This is the configuration file for Redirectionor.\n");
            writer.write("#\n");
            writer.write("# The following options can be enabled or disabled if there is a compatibility issue.\n");
            writer.write("# Add a line mixin.example_name=true/false without the # sign to enable/disable a rule.\n");
            writer.write("# All the mixins: \n");
            for(String line : this.options.keySet()) {
                writer.write("# " + line + "\n");
            }
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                writer.write(key + "=" + value + "\n");
            }
        }
    }

    private static String getMixinRuleName(String name) {
        return "mixin." + name;
    }

    public int getOptionCount() {
        return this.options.size();
    }

    public int getOptionOverrideCount() {
        return (int) this.options.values().stream().filter(Option::isOverridden).count();
    }

    public static RedirectionorMixinConfig load(File file) {
        RedirectionorMixinConfig config = new RedirectionorMixinConfig();
        Properties props = new Properties();
        if(file.exists()) {
            try (FileInputStream fin = new FileInputStream(file)){
                props.load(fin);
            } catch (IOException e) {
                throw new RuntimeException("Could not load config file", e);
            }
            config.readProperties(props);
        }

        try {
            config.writeConfig(file, props);
        } catch (IOException e) {
            LOGGER.warn("Could not write configuration file", e);
        }

        return config;
    }
}