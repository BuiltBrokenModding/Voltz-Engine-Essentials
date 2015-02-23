package com.builtbroken.vee.commands;

import com.builtbroken.mc.lib.transform.vector.Location;
import com.builtbroken.mc.prefab.commands.AbstractCommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by robert on 2/23/2015.
 */
public class CommandSetHome extends AbstractCommand
{
    public CommandSetHome()
    {
        super("sethome");
    }

    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String[] args)
    {
        player.addChatComponentMessage(new ChatComponentText("Home set"));
        player.getEntityData().setTag("home_pos", new Location(player).toNBT());
        return true;
    }

    @Override
    public boolean isHelpCommand(String[] args)
    {
        return false;
    }
}
