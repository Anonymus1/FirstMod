package io.github.caresist.first_mod.proxy;

import io.github.caresist.first_mod.handler.KeyHandler;
import io.github.caresist.first_mod.init.FirstModBlocks;
import io.github.caresist.first_mod.init.FirstModItems;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerProxies(){
        //register keyhandler
        FMLCommonHandler.instance().bus().register(new KeyHandler());
    }

    @Override
    public void registerRenders(){
        FirstModItems.registerRenders();
        FirstModBlocks.registerRenders();
    }
}
