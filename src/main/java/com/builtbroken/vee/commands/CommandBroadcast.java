package com.builtbroken.vee.commands;


import com.builtbroken.jlib.lang.TextColor;
import com.builtbroken.mc.prefab.commands.AbstractCommand;
import net.minecraft.command.ICommandSender;

/**
 * Created by snow on 9/16/2015.
 */
public class CommandBroadcast extends AbstractCommand {
    public CommandBroadcast() {
        super("broadcast");
    }

    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String[] args) {

        addChatToAllPlayers(TextColor.RED.getColorString() + "[Broadcast] " + combine(args));
        return true;
    }


}



