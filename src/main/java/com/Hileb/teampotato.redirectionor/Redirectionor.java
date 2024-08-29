package com.Hileb.teampotato.redirectionor;

import com.google.auto.service.AutoService;
import cpw.mods.modlauncher.api.ITransformer;
import net.neoforged.neoforgespi.coremod.ICoreMod;

import java.util.Collections;

@AutoService(ICoreMod.class)
public class Redirectionor implements IFMLLoadingPlugin {
    public Redirectionor(){
        try{
            RedirectionorConfig.initConfig();
        }catch (Exception e){
            throw new RuntimeException("unable to set up config for redirectionor",e);
        }
    }

    @Override
    public Iterable<? extends ITransformer<?>> getTransformers() {
        return Collections.singleton(new RedirectionorTransformer());
    }
}