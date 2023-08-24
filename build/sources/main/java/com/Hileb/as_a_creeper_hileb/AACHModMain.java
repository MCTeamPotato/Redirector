package com.Hileb.as_a_creeper_hileb;


import com.Hileb.as_a_creeper_hileb.mods.creeperconfetti.AACHInterfaceCCF;
import com.sr2610.creeperconfetti.ConfettiHandler;
import com.sr2610.creeperconfetti.ConfettiMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = AACHModMain.MODID, name = AACHModMain.NAME, version = AACHModMain.VERSION)//dependencies = "required-after:Forge@[14.23.5.2705,)"
public class AACHModMain {
    public static final String MODID = "assets/as_a_creeper_hileb";
    public static final String NAME = "As a creeper";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (Loader.isModLoaded(ConfettiMod.MOD_ID)){
            AACHInterfaceCCF.init();
        }
    }
}