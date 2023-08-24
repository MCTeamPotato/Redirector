package com.Hileb.as_a_creeper_hileb.mods.creeperconfetti;

import com.Hileb.as_a_creeper_hileb.item.ItemSkullBoom;
import com.google.common.collect.Lists;
import com.sr2610.creeperconfetti.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleFirework;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/18 15:43
 **/

public class OpenConfettiHandler {

    public static void creeperExplodeEvent(EntityPlayer player) {
        if (willExplodeToConfetti()){
            World world=player.world;
            world.playSound(player,player.posX,player.posY,player.posZ,SoundEvents.ENTITY_FIREWORK_TWINKLE,SoundCategory.BLOCKS,0.5F, (1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F) * 0.7F);
            if (world.isRemote) {
                spawnParticles(player);
            }
            if (ConfigHandler.damagesPlayers) {
                damagePlayers(player);
            }
        }
    }

    public static  boolean willExplodeToConfetti() {
        Random rand = new Random();
        return rand.nextInt(100) < ConfigHandler.confettiChance && ConfigHandler.confettiChance != 0;
    }

    public static void damagePlayers(EntityPlayer player) {
        ItemStack stack=player.getHeldItem(player.getActiveHand());
        float explosionStrength = ItemSkullBoom.isCharged(stack) ? 2.0F : 1.0F;
        Explosion explosion = new Explosion(player.world, player,player.posX, player.posY, player.posZ, 3.0F * explosionStrength, false, false);
        explosion.doExplosionA();
    }

    @SideOnly(Side.CLIENT)
    public static void spawnParticles(EntityPlayer creeper) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleFirework.Starter(creeper.getEntityWorld(), creeper.posX, creeper.posY + 0.5, creeper.posZ, 0.0, 0.0, 0.0, Minecraft.getMinecraft().effectRenderer, generateTag()));
    }

    public static NBTTagCompound generateTag() {
        NBTTagCompound fireworkTag = new NBTTagCompound();
        new NBTTagCompound();
        NBTTagCompound fireworkItemTag = new NBTTagCompound();
        new NBTTagCompound();
        NBTTagList nbttaglist = new NBTTagList();
        new NBTTagList();
        List<Integer> list = Lists.newArrayList();
        Random rand = new Random();
        list.add(ItemDye.DYE_COLORS[1]);
        list.add(ItemDye.DYE_COLORS[11]);
        list.add(ItemDye.DYE_COLORS[4]);

        for(int i = 0; i < rand.nextInt(3) + 3; ++i) {
            list.add(ItemDye.DYE_COLORS[rand.nextInt(15)]);
        }

        int[] colours = new int[list.size()];

        for(int i = 0; i < colours.length; ++i) {
            colours[i] = (Integer)list.get(i);
        }

        fireworkTag.setIntArray("Colors", colours);
        fireworkTag.setBoolean("Flicker", true);
        fireworkTag.setByte("Type", (byte)4);
        nbttaglist.appendTag(fireworkTag);
        fireworkItemTag.setTag("Explosions", nbttaglist);
        return fireworkItemTag;
    }
}
