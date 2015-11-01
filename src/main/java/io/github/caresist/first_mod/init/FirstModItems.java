package io.github.caresist.first_mod.init;

import io.github.caresist.first_mod.FirstMod;
import io.github.caresist.first_mod.Reference;
import io.github.caresist.first_mod.items.ItemLightningPickaxe;
import io.github.caresist.first_mod.items.ItemLightningSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FirstModItems {

    public static Item first_item;
    public static Item lightning_sword;
    public static Item lightning_rod;
    public static Item lightning_pickaxe;
    public static final Item.ToolMaterial LIGHTNINGTOOLMATERIAL = EnumHelper.addToolMaterial("LIGHTNINGTOOLMATERIAL",4,7000,42F,7.0F,50);
    //public static Item template_example;

    public static void init(){
        first_item = new Item().setUnlocalizedName("first_item").setCreativeTab(FirstMod.tabFirst);
        lightning_sword = new ItemLightningSword(LIGHTNINGTOOLMATERIAL).setUnlocalizedName("lightning_sword").setCreativeTab(FirstMod.tabFirst);
        lightning_rod = new Item().setUnlocalizedName("lightning_rod").setCreativeTab(FirstMod.tabFirst);
        lightning_pickaxe = new ItemLightningPickaxe(LIGHTNINGTOOLMATERIAL).setUnlocalizedName("lightning_pickaxe").setCreativeTab(FirstMod.tabFirst);
    }

    public static void register(){
        GameRegistry.registerItem(first_item,first_item.getUnlocalizedName().substring(5)); //"tile.first_item" -first 5 chars = first_item
        GameRegistry.registerItem(lightning_sword, lightning_sword.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(lightning_rod, lightning_rod.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(lightning_pickaxe, lightning_pickaxe.getUnlocalizedName().substring(5));
    }

    public static void registerRenders(){
        registerRender(first_item);
        registerRender(lightning_sword);
        registerRender(lightning_rod);
        registerRender(lightning_pickaxe);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
