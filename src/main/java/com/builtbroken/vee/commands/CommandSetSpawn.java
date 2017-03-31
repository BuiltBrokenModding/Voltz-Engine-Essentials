package com.builtbroken.vee.commands;

import com.builtbroken.mc.core.commands.prefab.AbstractCommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by robert on 2/23/2015.
 */
public class CommandSetSpawn extends AbstractCommand
{
    public CommandSetSpawn()
    {
        super("setspawn");
    }

    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String[] args)
    {
        player.worldObj.setSpawnLocation((int)player.posX, (int)player.posY, (int)player.posZ);
        player.addChatComponentMessage(new ChatComponentText("*Spawn*"));
        return true;
    }

    @Override
    public boolean isHelpCommand(String[] args)
    {
        return false;
    }
}
