package io.github.caresist.first_mod;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class FindClosestMob {
    public static void findClosestMob(World worldIn, EntityPlayer playerIn) {
        float closest = Float.MAX_VALUE;
        Entity thisOne = null;
        for (int i = 0; i < worldIn.loadedEntityList.size(); i++) {
            if (((Entity) worldIn.loadedEntityList.get(i)).getDistanceToEntity(playerIn) < closest) {
                if ((worldIn.loadedEntityList.get(i) instanceof EntityMob) || (worldIn.loadedEntityList.get(i) instanceof EntityOtherPlayerMP) ) /*|| (worldIn.loadedEntityList.get(i) instanceof EntityPlayerMP) || (worldIn.loadedEntityList.get(i) instanceof EntityPlayer)*/ //if it is a mob...
                {
                    closest = ((Entity) worldIn.loadedEntityList.get(i)).getDistanceToEntity(playerIn);
                    thisOne = ((Entity) worldIn.loadedEntityList.get(i));
                }
            }
        }
        if (thisOne != null) {

            //THIS IS WHERE THE AWESOME STUFF HAPPENS
            double difX = thisOne.posX - playerIn.posX;
            double difY = thisOne.posY - playerIn.posY;
            double difZ = thisOne.posZ - playerIn.posZ;

            float pitchOld = playerIn.rotationPitch;
            float yawOld = playerIn.rotationYaw;

            double radius = Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2) + Math.pow(difZ, 2));
            double newPitch = -Math.asin(difY / radius) / Math.PI * 180;
            double newYaw =  -Math.atan2(difX,difZ) / Math.PI * 180;
            //double newYaw = 0.0D;
            playerIn.rotationPitch = (float) newPitch;
            playerIn.rotationYaw = (float) newYaw;

            float pitch = playerIn.rotationPitch;
            float yaw = playerIn.rotationYaw;
            System.out.println("P+Y:" + pitch +" "+ yaw +"  "+pitchOld + " "+ yawOld+"  "+"M:"+thisOne.posX +" " +thisOne.posY+" " + thisOne.posZ + "  "+"P:" + playerIn.posX + " " + playerIn.posY + " " + playerIn.posZ + "  " +"D:"+ difX + " " + difY + " " + difZ);

            //worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, thisOne.posX, thisOne.posY, thisOne.posZ));
        }
    }
}