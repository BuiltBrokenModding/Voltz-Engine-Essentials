package com.builtbroken.vee.commands;

import com.builtbroken.mc.imp.transform.vector.Location;
import com.builtbroken.mc.core.commands.prefab.AbstractCommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

/**
 * Created by robert on 2/23/2015.
 */
public class CommandBack extends AbstractCommand
{
    public CommandBack()
    {
        super("back");
    }

    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String[] args)
    {
        if (player.getEntityData().hasKey("last_tp_pos"))
        {
            Location location = new Location(player.getEntityData().getCompoundTag("last_tp_pos"));
            if (location.world() == player.worldObj)
            {
                if (player instanceof EntityPlayerMP)
                {
                    ((EntityPlayerMP) player).playerNetServerHandler.setPlayerLocation(location.x(), location.y(), location.z(), ((EntityPlayerMP) player).rotationYaw, ((EntityPlayerMP) player).rotationPitch);
                    player.addChatComponentMessage(new ChatComponentText("*Teleported*"));
                }
                else
                {
                    player.addChatComponentMessage(new ChatComponentText("Error not instance of EntityPlayerMP"));
                }
            }
            else
            {
                player.addChatComponentMessage(new ChatComponentText("Error can't cross dim teleport yet"));
            }
        }
        else
        {
            player.addChatComponentMessage(new ChatComponentText("No location saved to use the /back command"));
        }
        return true;
    }

    @Override
    public boolean isHelpCommand(String[] args)
    {
        return false;
    }
}