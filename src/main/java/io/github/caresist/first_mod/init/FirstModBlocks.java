package io.github.caresist.first_mod.init;


import io.github.caresist.first_mod.FirstMod;
import io.github.caresist.first_mod.Reference;
import io.github.caresist.first_mod.blocks.FirstBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FirstModBlocks {
    public static Block first_block;
    public static void init(){
        first_block = new FirstBlock(Material.cloth).setUnlocalizedName("first_block").setCreativeTab(FirstMod.tabFirst);
    }

    public static void register(){
        GameRegistry.registerBlock(first_block,first_block.getUnlocalizedName().substring(5));
    }
    public static void registerRenders(){
        registerRender(first_block);
    }
    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
