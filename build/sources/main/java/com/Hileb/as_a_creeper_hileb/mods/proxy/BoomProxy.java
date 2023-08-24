package com.Hileb.as_a_creeper_hileb.mods.proxy;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/18 16:04
 **/
public abstract class BoomProxy {
    public abstract boolean canHandler(ItemStack stack, World worldIn, EntityLivingBase entityLiving);
    public abstract ItemStack run(ItemStack stack, World worldIn, EntityLivingBase entityLiving);
}
