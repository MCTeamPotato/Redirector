package com.Hileb.teampotato.redirectionor;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/24 13:37
 **/
@Mod.EventBusSubscriber
public class AAA {
    @SubscribeEvent
    public static void on(PlayerEvent.PlayerLoggedInEvent event){
        EAA.values();
        FMLLog.log.error("aaa");
    }
    public static enum EAA{
        AAA,
        AAE,
        AAT
    }
}
