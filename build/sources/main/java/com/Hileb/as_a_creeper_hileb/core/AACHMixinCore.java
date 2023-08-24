package com.Hileb.as_a_creeper_hileb.core;

import com.Hileb.as_a_creeper_hileb.AACHModMain;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/17 17:14
 **/
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.Name(AACHModMain.NAME)
public class AACHMixinCore implements IEarlyMixinLoader , IFMLLoadingPlugin {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixin.aach.hileb.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
