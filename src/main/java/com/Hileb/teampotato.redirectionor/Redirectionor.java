package com.Hileb.teampotato.redirectionor;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.Name(Redirectionor.MODID)
public class Redirectionor implements IFMLLoadingPlugin {
    public static final String MODID = "redirectionor";

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                ""
        };
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