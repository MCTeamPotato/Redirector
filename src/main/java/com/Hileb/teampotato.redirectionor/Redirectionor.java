package com.Hileb.teampotato.redirectionor;

import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.Name(Redirectionor.MODID)
public class Redirectionor implements IFMLLoadingPlugin {

    public Redirectionor(){
        try{
            RedirectionorConfig.initConfig();
        }catch (Exception e){
            throw new RuntimeException("unable to set up config for redirectionor",e);
        }
    }

    public static void makeFMLCorePluginContainsFMLMod(File file){
        String name = file.getName();
        CoreModManager.getIgnoredMods().remove(name);
        CoreModManager.getReparseableCoremods().add(name);
    }

    public static final String MODID = "redirectionor";

    public static final String TRANSFORMERCLASS = "com.Hileb.teampotato.redirectionor.RedirectionorTransformer";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

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
//        if (data.containsKey("coremodLocation")){
//            makeFMLCorePluginContainsFMLMod((File)data.get("coremodLocation"));
//        }
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}