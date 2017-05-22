package com.builtbroken.vee.commands;

import com.builtbroken.mc.core.commands.prefab.AbstractCommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

/**
 * Created by robert on 2/23/2015.
 */
public class CommandSpawn extends AbstractCommand
{
    public CommandSpawn()
    {
        super("spawn");
    }

    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String[] args)
    {
        if (player instanceof EntityPlayerMP)
        {
            ((EntityPlayerMP) player).playerNetServerHandler.setPlayerLocation(player.worldObj.getSpawnPoint().posX, player.worldObj.getSpawnPoint().posY, player.worldObj.getSpawnPoint().posZ, ((EntityPlayerMP) player).rotationYaw, ((EntityPlayerMP) player).rotationPitch);
            player.addChatComponentMessage(new ChatComponentText("*Teleported*"));
        }
        else
        {
            player.addChatComponentMessage(new ChatComponentText("Error not instance of EntityPlayerMP"));
        }
        return true;
    }

    @Override
    public boolean isHelpCommand(String[] args)
    {
        return false;
    }
}

