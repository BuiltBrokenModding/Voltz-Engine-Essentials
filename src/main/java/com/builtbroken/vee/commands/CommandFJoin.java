package com.builtbroken.vee.commands;

import com.builtbroken.jlib.lang.TextColor;
import com.builtbroken.mc.prefab.commands.AbstractCommand;
import net.minecraft.command.ICommandSender;

/**
 * Created by snowf on 9/17/2015.
 */
public class CommandFJoin extends AbstractCommand {
    public CommandFJoin() {
        super("fjoin");
    }

    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String[] args) {

        addChatToAllPlayers(TextColor.YELLOW.getColorString()  +combine(args) + " joined the game");
        return true;
    }
}

