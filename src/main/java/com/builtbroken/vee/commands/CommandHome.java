package com.builtbroken.vee.commands;

import com.builtbroken.mc.imp.transform.vector.Location;
import com.builtbroken.mc.core.commands.prefab.AbstractCommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

/**
 * Created by robert on 2/23/2015.
 */
public class CommandHome extends AbstractCommand
{
    public CommandHome()
    {
        super("home");
    }

    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String[] args)
    {
        if (player.getEntityData().hasKey("home_pos"))
        {
            Location location = new Location(player.getEntityData().getCompoundTag("home_pos"));
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
                player.addChatComponentMessage(new ChatComponentText("Need to be in the same world as your home"));
            }
        }
        else
        {
            player.addChatComponentMessage(new ChatComponentText("You don't have a home yet /sethome to set it"));
        }
        return true;
    }

    @Override
    public boolean isHelpCommand(String[] args)
    {
        return false;
    }
}
