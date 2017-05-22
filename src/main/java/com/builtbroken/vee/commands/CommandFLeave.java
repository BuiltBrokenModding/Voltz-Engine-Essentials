package com.builtbroken.vee.commands;

import com.builtbroken.jlib.lang.TextColor;
import com.builtbroken.mc.core.commands.prefab.AbstractCommand;
import net.minecraft.command.ICommandSender;

/**
 * Created by snowf on 9/17/2015.
 */
public class CommandFLeave extends AbstractCommand {
    public CommandFLeave() {
        super("fleave");
    }

    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String[] args) {

        addChatToAllPlayers(TextColor.YELLOW.getColorString()  +combine(args) + " left the game");
        return true;
    }
        }




