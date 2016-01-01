package io.github.caresist.first_mod.handler;

import io.github.caresist.first_mod.FindClosestMob;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;


public class KeyHandler {

    public static final int AIMBOT_KEY = 0;
    public static final int PROGRAMMER_KEY = 1;
    public static final int AIMLOCK_KEY = 2;

    private static final String[] KEYDESC = {"key.firstmod.aimbot.desc", "key.firstmod.coding.desc", "key.firstmod.aimlock.desc"};
    private static final int[] KEYVALUES = {Keyboard.KEY_R, Keyboard.KEY_SEMICOLON, Keyboard.KEY_F};
    private final KeyBinding[] KEYS;

    public KeyHandler(){
        KEYS = new KeyBinding[KEYVALUES.length];
        for(int i = 0; i < KEYVALUES.length; i++){
            KEYS[i] = new KeyBinding(KEYDESC[i], KEYVALUES[i], "key.firstmod.category");
            ClientRegistry.registerKeyBinding(KEYS[i]);
        }
    }
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(!FMLClientHandler.instance().isGUIOpen(GuiChat.class)){
            int key = Keyboard.getEventKey();
            boolean isDown = Keyboard.getEventKeyState();

                if(isDown && key == KEYVALUES[AIMBOT_KEY]) {
                    World world = Minecraft.getMinecraft().theWorld;
                    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                    FindClosestMob.findClosestMob(world, player);
                }

                while (isDown && key == KEYVALUES[AIMLOCK_KEY]) {
                    World world = Minecraft.getMinecraft().theWorld;
                    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                    FindClosestMob.findClosestMob(world, player);
                }

                if(isDown && key == KEYVALUES[PROGRAMMER_KEY]){
                    EntityPlayer playerIn = Minecraft.getMinecraft().thePlayer;
                    ChatComponentText text = new ChatComponentText("Sorry, this isn't developed yet.");
                    playerIn.addChatMessage(text);
                    /*Alternate ways
                    playerIn.addChatMessage(text.createCopy());
                    playerIn.addChatComponentMessage(text);
                    playerIn.addChatComponentMessage(text.createCopy());*/
                }
        }
    }
}