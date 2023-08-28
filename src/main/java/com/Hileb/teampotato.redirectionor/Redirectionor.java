package com.Hileb.teampotato.redirectionor;


import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name(Redirectionor.MODID)
public class Redirectionor implements IFMLLoadingPlugin {

    public static final String MODID = "redirectionor";

    public static final String TRANSFORMERCLASS="com.Hileb.teampotato.redirectionor.RedirectionorTansformer";


    @Override
    public String[] getASMTransformerClass() {
        return new String[]{TRANSFORMERCLASS};
    }

    @Override
    public String getModContainerClass() {
        return "com.Hileb.teampotato.redirectionor.RedirectionorContainer";
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