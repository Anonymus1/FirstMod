package io.github.caresist.first_mod;

import io.github.caresist.first_mod.blocks.FirstBlock;
import io.github.caresist.first_mod.init.FirstModBlocks;
import io.github.caresist.first_mod.init.FirstModItems;
import io.github.caresist.first_mod.proxy.CommonProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.input.Keyboard;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class FirstMod {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final FirstTab tabFirst = new FirstTab("tabFirst");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        FirstModBlocks.init();
        FirstModBlocks.register();
        FirstModItems.init();
        FirstModItems.register();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
        proxy.registerProxies();
        proxy.registerRenders();
        GameRegistry.addRecipe(new ItemStack(FirstModItems.lightning_sword), new Object[]{" O "," O "," R ", 'O', Blocks.obsidian, 'R', FirstModItems.lightning_rod});
        GameRegistry.addRecipe(new ItemStack(FirstModItems.lightning_rod), new Object[] {" G "," O "," G ",'O',Blocks.obsidian,'G', Items.glowstone_dust});
        //GameRegistry.addRecipe(new ItemStack(FirstModItems.lightning_pickaxe));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
