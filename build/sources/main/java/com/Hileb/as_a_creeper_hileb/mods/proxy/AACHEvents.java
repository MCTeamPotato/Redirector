package com.Hileb.as_a_creeper_hileb.mods.proxy;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/18 16:02
 **/
public class AACHEvents {
    public static class ProxyEvent extends Event{
        public List<BoomProxy> proxys=new ArrayList<>();
        public void register(BoomProxy boomProxy){
            proxys.add(boomProxy);
        }

        @Override
        public boolean isCancelable() {
            return true;
        }
    }
}
