package com.Hileb.as_a_creeper_hileb.item;

import com.Hileb.as_a_creeper_hileb.AACHModMain;
import com.Hileb.as_a_creeper_hileb.mods.proxy.AACHEvents;
import com.Hileb.as_a_creeper_hileb.mods.proxy.BoomProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static net.minecraft.util.DamageSource.LIGHTNING_BOLT;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/17 16:23
 **/
@Mod.EventBusSubscriber
public class ItemSkullBoom extends Item {
    public static float[] RETURNS=new float[]{
            0.035714287f,
            0.071428575f,
            0.035714287f,
            0.071428575f,
            0.10714286f,
            0.14285715f,
            0.17857143f,
            0.21428572f,
            0.25f,
            0.2857143f,
            0.32142857f,
           0.35714287f,
           0.39285713f,
            0.42857143f,
            0.4642857f,
            0.5f,
            0.53571427f,
           0.5714286f,
            0.60714287f,
            0.64285713f,
            0.6785714f,
            0.71428573f,
            0.75f,
            0.78571427f,
            0.8214286f,
            0.85714287f,
            0.89285713f,
            0.9285714f,
            0.96428573f,
            1.0f,
            1.0357143f
    };
    public static final ItemSkullBoom ITEM=new ItemSkullBoom();
    private ItemSkullBoom(){
        super();
        setUnlocalizedName("aach.item");
        setRegistryName("item");
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(64);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 30;
    }
    public static boolean isCharged(ItemStack stack){
        if (stack.getItem()==ITEM && !stack.isEmpty()){
            NBTTagCompound nbt=stack.getTagCompound();
            if (nbt!= null && nbt.hasKey("hileb.isCharged")){
                return nbt.getBoolean("hileb.isCharged");
            }
        }
        return false;
    }
    public static void charge(ItemStack stack){
        if (!stack.isEmpty()) {
            if (stack.getTagCompound()==null)stack.setTagCompound(new NBTTagCompound());
            NBTTagCompound tag=stack.getTagCompound();
            tag.setBoolean("hileb.isCharged",true);
        }
    }
    public static BoomProxy BASE_PROXY=new BoomProxy() {
        @Override
        public boolean canHandler(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
            return true;
        }

        @Override
        public ItemStack run(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
            if (!worldIn.isRemote){
                boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(worldIn, entityLiving);
                boolean isCharged=isCharged(stack);
                int energy=isCharged?6:3;
                worldIn.createExplosion(entityLiving, entityLiving.posX, entityLiving.posY, entityLiving.posZ, energy, flag);
                if (!(entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).capabilities.isCreativeMode)){
                    stack.shrink(1);
                }
            }
            return stack;
        }
    };

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        AACHEvents.ProxyEvent event=new AACHEvents.ProxyEvent();
        boolean flag=MinecraftForge.EVENT_BUS.post(event);
        if (flag)return stack;
        for(BoomProxy boomProxy:event.proxys){
            if (boomProxy.canHandler(stack,worldIn,entityLiving)){
                return boomProxy.run(stack,worldIn,entityLiving);
            }
        }
        return BASE_PROXY.run(stack,worldIn,entityLiving);
    }

    public static boolean isPlayerUsingItem(EntityPlayer player){
        if (player.isHandActive()){
            ItemStack stack=player.getActiveItemStack();
            if (ItemSkullBoom.ITEM==stack.getItem()){
                return true;
            }
        }
        return false;
    }
    public static float getPlayerFlashIntensity(EntityPlayer player,float f){
        int t= (int)(player.getItemInUseCount()+f);
        if (t<=0)t=0;
        if (t>=29)t=29;
        return RETURNS[29-t];
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        playerIn.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return isCharged(stack);
    }
    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return stack.getMetadata() == 0 ? EnumRarity.RARE : EnumRarity.EPIC;
    }
    //----static-----event----//
    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().register(ITEM);
    }
    @SubscribeEvent
    public static void onRecipeRegister(RegistryEvent.Register<IRecipe> event){
        event.getRegistry().register(new ShapelessOreRecipe(
                new ResourceLocation(AACHModMain.MODID,"recipe"),
                new ItemStack(ITEM),
                new ItemStack(Items.SKULL,1,4),
                Blocks.TNT
        ).setRegistryName(AACHModMain.VERSION,"recipe"));
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ITEM, 0, new ModelResourceLocation("as_a_creeper_hileb:model", "inventory"));
    }
    @SubscribeEvent
    public static void onLightCharged(LivingHurtEvent event){
        World world=event.getEntity().world;
        if (!world.isRemote){
            if (event.getSource()==LIGHTNING_BOLT){
                EntityLivingBase entity=event.getEntityLiving();
                if (entity instanceof IInventory){
                    IInventory inv=(IInventory) entity;
                    for(int i=0;i<inv.getSizeInventory();i++){
                        ItemStack stack=inv.getStackInSlot(i);
                        if (stack.getItem()==ITEM && !isCharged(stack)){
                            charge(stack);
                            event.setAmount(0);
                        }
                    }
                }
                for(EnumFacing facing:EnumFacing.values()){
                    if (entity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,facing)){
                        IItemHandler ith=entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,facing);
                        for(int i=0;i< ith.getSlots();i++){
                            ItemStack stack=ith.getStackInSlot(i);
                            if (stack.getItem()==ITEM && !isCharged(stack)){
                                charge(stack);
                                event.setAmount(0);
                            }
                        }
                    }
                }
                if (entity instanceof EntityPlayer){
                    EntityPlayer player=(EntityPlayer) entity;
                    IInventory inv=player.inventory;
                    for(int i=0;i<inv.getSizeInventory();i++){
                        ItemStack stack=inv.getStackInSlot(i);
                        if (stack.getItem()==ITEM && !isCharged(stack)){
                            charge(stack);
                            event.setAmount(0);
                        }
                    }
                }
            }
        }
    }
}
