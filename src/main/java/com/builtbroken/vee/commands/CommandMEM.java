package com.builtbroken.vee.commands;

import com.builtbroken.jlib.lang.TextColor;
import com.builtbroken.mc.core.commands.prefab.AbstractCommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import com.builtbroken.jlib.lang.StringHelpers;

/**
 * Created by snowf on 9/17/2015.
 */
public class CommandMEM  extends AbstractCommand {
    public CommandMEM() {
        super("mem");
    }
    private Runtime runtime = Runtime.getRuntime();

    public long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }
    public long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }



    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String[] args) {
        String maxMemory = StringHelpers.DECIMAL_FORMAT.format((runtime.totalMemory()/ 1024 / 1024) - ( runtime.freeMemory()/ 1024 / 1024));
        String allocatedMemory =StringHelpers.DECIMAL_FORMAT.format( runtime.totalMemory()/ 1024 / 1024);
        String freeMemory =StringHelpers.DECIMAL_FORMAT.format( runtime.freeMemory()/ 1024 / 1024);
        float percent = (float) (runtime.totalMemory() - runtime.freeMemory()) / (float) runtime.totalMemory();
        int percentDisplay = (int) (percent *100);

        if (percentDisplay <=25){
        sender.addChatMessage(new ChatComponentText(TextColor.BRIGHTGREEN.getColorString() +"[Total Memory]: " + allocatedMemory + "MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.BRIGHTGREEN.getColorString() +"[Used Memory]: " + maxMemory +"MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.BRIGHTGREEN.getColorString() +"[Free Memory]: " + freeMemory + "MB"));
        return true;}

        else

        if (percentDisplay <=50){
        sender.addChatMessage(new ChatComponentText(TextColor.YELLOW.getColorString() +"[Total Memory]: " + allocatedMemory + "MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.YELLOW.getColorString() + "[Used Memory]: " + maxMemory +"MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.YELLOW.getColorString() + "[Free Memory]: " + freeMemory + "MB"));
        return true;}

        else

        if (percentDisplay <=75){
        sender.addChatMessage(new ChatComponentText(TextColor.GOLD.getColorString() +"[Total Memory]: " + allocatedMemory + "MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.GOLD.getColorString() +"[Used Memory]: " + maxMemory +"MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.GOLD.getColorString() +"[Free Memory]: " + freeMemory + "MB"));
        return true;}

        else
        sender.addChatMessage(new ChatComponentText(TextColor.RED.getColorString() +"[Total Memory]: " + allocatedMemory + "MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.RED.getColorString() +"[Used Memory]: " + maxMemory +"MB"));
        sender.addChatMessage(new ChatComponentText(TextColor.RED.getColorString() +"[Free Memory]: " + freeMemory + "MB"));
        return true;
    }
    @Override
    public boolean isHelpCommand(String[] args) {
        return false;
    }
}
