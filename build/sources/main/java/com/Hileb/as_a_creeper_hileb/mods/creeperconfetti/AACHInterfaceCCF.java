package com.Hileb.as_a_creeper_hileb.mods.creeperconfetti;

import com.Hileb.as_a_creeper_hileb.mods.proxy.AACHEvents;
import com.Hileb.as_a_creeper_hileb.mods.proxy.BoomProxy;
import com.sr2610.creeperconfetti.ConfettiHandler;
import com.sr2610.creeperconfetti.ConfettiMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/18 15:40
 **/

public class AACHInterfaceCCF extends BoomProxy {
    public static void init(){
        MinecraftForge.EVENT_BUS.register(new AACHInterfaceCCF());
    }
    public AACHInterfaceCCF(){}
    @SubscribeEvent
    public void onRegister(AACHEvents.ProxyEvent event){
        event.register(this);
    }

    @Override
    public boolean canHandler(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        return Loader.isModLoaded(ConfettiMod.MOD_ID) && entityLiving instanceof EntityPlayer;
    }

    @Override
    public ItemStack run(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        OpenConfettiHandler.creeperExplodeEvent((EntityPlayer)entityLiving);
        if (!worldIn.isRemote && !((EntityPlayer)entityLiving).capabilities.isCreativeMode){
            stack.shrink(1);
        }
        return stack;
    }
}
