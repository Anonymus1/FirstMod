package io.github.caresist.first_mod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;

import java.util.List;

public class ItemLightningSword extends ItemSword {

    public ItemLightningSword(ToolMaterial material) {
        super(material);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

        return false;
    }
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){

        double x = 4 * playerIn.getLookVec().xCoord + playerIn.posX;
        double y = 4 * playerIn.getLookVec().yCoord + playerIn.posY;
        double z = 4 * playerIn.getLookVec().zCoord + playerIn.posZ;
        EntityLightningBolt lightning = new EntityLightningBolt(worldIn, x, y, z);
        worldIn.spawnEntityInWorld(lightning);
        //playerIn.setPosition(x,y,z);
        return itemStackIn;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {

    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return stack.isItemEnchanted();
    }

}
