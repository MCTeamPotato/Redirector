package com.teampotato.redirectionor.config;

import net.minecraftforge.fml.loading.FMLLoader;
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
        this.addMixinRule("advancements", true);
        this.addMixinRule("chat", true);
        this.addMixinRule("client", true);
        this.addMixinRule("client.", true);
        this.addMixinRule("client.gui", true);
        this.addMixinRule("client.gui.components", true);
        this.addMixinRule("client.gui.screens", true);
        this.addMixinRule("client.gui.screens.advancements", true);
        this.addMixinRule("client.gui.screens.inventory", true);
        this.addMixinRule("client.gui.screens.reporting", true);
        this.addMixinRule("client.model.geom", true);
        this.addMixinRule("client.multiplayer", true);
        this.addMixinRule("client.renderer", true);
        this.addMixinRule("client.renderer.block.model", true);
        this.addMixinRule("client.renderer.chunk", true);
        this.addMixinRule("client.renderer.entity", true);
        this.addMixinRule("client.renderer.entity.layers", true);
        this.addMixinRule("client.resources", true);
        this.addMixinRule("client.resources.model", true);
        this.addMixinRule("client.resources.sounds", true);
        this.addMixinRule("client.resources.tutorial", true);
        this.addMixinRule("commands.arguments", true);
        this.addMixinRule("commands.arguments.selector.options", true);
        this.addMixinRule("compat", true);
        this.addMixinRule("compat.modernfix", isNotLoaded("modernfix"));
        this.addMixinRule("compat.lithium", isNotLoaded("lithium") && isNotLoaded("roadrunner") && isNotLoaded("canary"));
        this.addMixinRule("compat.nicerportals", isNotLoaded("nicerportals"));
        this.addMixinRule("compat.sodium", isNotLoaded("sodium") && isNotLoaded("rubidium") && isNotLoaded("magnesium") && isNotLoaded("chlorine"));
        this.addMixinRule("core", true);
        this.addMixinRule("data", true);
        this.addMixinRule("data.loot", true);
        this.addMixinRule("data.model", true);
        this.addMixinRule("data.worldgen", true);
        this.addMixinRule("network.protocol.game", true);
        this.addMixinRule("server", true);
        this.addMixinRule("server.commands", true);
        this.addMixinRule("server.level", true);
        this.addMixinRule("server.packs", true);
        this.addMixinRule("stats", true);
        this.addMixinRule("util", true);
        this.addMixinRule("world", true);
        this.addMixinRule("world.entity", true);
        this.addMixinRule("world.entity.ai", true);
        this.addMixinRule("world.entity.ai.behavior", true);
        this.addMixinRule("world.entity.ai.goal", true);
        this.addMixinRule("world.entity.animal", true);
        this.addMixinRule("world.entity.animal.axolotl", true);
        this.addMixinRule("world.entity.animal.horse", true);
        this.addMixinRule("world.entity.monster", true);
        this.addMixinRule("world.entity.projectile", true);
        this.addMixinRule("world.item", true);
        this.addMixinRule("world.level", true);
        this.addMixinRule("world.level.block", true);
        this.addMixinRule("world.level.block.entity", true);
        this.addMixinRule("world.level.block.piston", isNotLoaded("canary") && isNotLoaded("roadrunner"));
        this.addMixinRule("world.level.block.state", true);
        this.addMixinRule("world.level.block.state.pattern", true);
        this.addMixinRule("world.level.chunk", true);
        this.addMixinRule("world.level.chunk.storage", true);
        this.addMixinRule("world.level.gameevent.vibrations", true);
        this.addMixinRule("world.level.levelgen", true);
        this.addMixinRule("world.level.levelgen.blending", true);
        this.addMixinRule("world.level.levelgen.feature", true);
        this.addMixinRule("world.level.levelgen.structure", true);
        this.addMixinRule("world.level.levelgen.structure.structures", true);
        this.addMixinRule("world.level.levelgen.structure.templatesystem", true);
        this.addMixinRule("world.level.material", true);
        this.addMixinRule("world.level.pathfinder", true);
        this.addMixinRule("world.level.saveddata.maps", true);
        this.addMixinRule("world.level.storage.loot", true);
        this.addMixinRule("world.level.storage.loot.functions", true);
        this.addMixinRule("world.ticks", true);
    }

    private static boolean isNotLoaded(String modID) {
        return FMLLoader.getLoadingModList().getModFileById(modID) == null;
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
