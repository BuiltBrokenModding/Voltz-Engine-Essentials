package com.builtbroken.vee.commands;

import com.builtbroken.jlib.lang.TextColor;
import com.builtbroken.mc.lib.helper.MathUtility;
import com.builtbroken.mc.prefab.commands.AbstractCommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by snowf on 9/17/2015.
 */
public class CommandCompass extends AbstractCommand {
    public CommandCompass() {
        super("compass");
    }
    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String[] args) {
        MathUtility.getFacingDirectionFromAngle(player.rotationYaw);
        ForgeDirection dir = MathUtility.getFacingDirectionFromAngle(player.rotationYaw);
        int degrees = ((int)player.rotationYaw);
        player.addChatComponentMessage(new ChatComponentText(TextColor.PURPLE.getColorString() + "You are facing " + dir.name().toLowerCase() + " at " + degrees + " degrees"));
        return true;

    }

    @Override
    public boolean isHelpCommand(String[] args) {
        return false;
    }


}
