package com.builtbroken.vee.commands;

import com.builtbroken.mc.core.commands.ext.SubCommandWithName;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.List;

/**
 * /sethp snow 20
 * Created by snow/Kolatra on 9/16/2015.
 */

public class CommandSETHP extends SubCommandWithName {

    public CommandSETHP() {
        super("sethp");
    }


    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "sethp <amount>";
    }


    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String user, String[] args) {
        if (args != null && args.length == 1){
            return handleConsoleCommand(player, user, args);
        }
        else
            if (player != null) {
                try {
                    float hp = Float.parseFloat(user);
                    float prev_hp = player.getHealth();
                    player.setHealth(hp);
                    if (hp > prev_hp) {
                        player.addChatComponentMessage(new ChatComponentText("You have been blessed by the gods."));
                    } else if (hp < prev_hp)
                        player.addChatComponentMessage(new ChatComponentText("You have smiten by the gods."));
                    return true;

                } catch (NumberFormatException e) {
                    player.addChatMessage(new ChatComponentText("You need to use a number for the health value"));
                    return true;
                }
            }
        return true;
    }

    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String user, String[] args) {
        EntityPlayer player = getPlayer(sender, user);
        if (user != null) {
            try {
                float hp = Float.parseFloat(args[0]);
                float prev_hp = player.getHealth();
                player.setHealth(hp);
                if (hp > prev_hp) {
                    player.addChatComponentMessage(new ChatComponentText("You have been blessed by the gods."));
                } else if (hp < prev_hp)
                    player.addChatComponentMessage(new ChatComponentText("You have smiten by the gods."));
                return true;

            } catch (NumberFormatException e) {
                sender.addChatMessage(new ChatComponentText("You need to use a number for the health value"));
                return true;
            }
        } else {
            player.addChatComponentMessage(new ChatComponentText("Player is not online, or username is incorrect"));
            return true;

        }
    }
    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args)
        {
            if (args != null && args.length == 1)
                return getListOfStringsMatchingLastWord(args, this.playersOnlineByUsername());
            return null;
        }
}
