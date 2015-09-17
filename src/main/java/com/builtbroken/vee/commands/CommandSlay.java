package com.builtbroken.vee.commands;

import com.builtbroken.mc.core.commands.ext.SubCommandWithName;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.List;

/**
 * Created by snowf on 9/16/2015.
 */
public class CommandSlay extends SubCommandWithName {

    public CommandSlay() {
        super("slay");
    }


    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "slay <player>";
    }

    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String user, String[] args) {
        EntityPlayer player = getPlayer(sender, user);
        if (user != null) {

            player.setHealth(0);
            player.addChatComponentMessage(new ChatComponentText("You have smiten by the gods."));
            return true;

        } else {
            player.addChatComponentMessage(new ChatComponentText("Player is not online, or username is incorrect"));
            return true;

        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args != null && args.length == 1)
            return getListOfStringsMatchingLastWord(args, this.playersOnlineByUsername());
        return null;
    }
}

