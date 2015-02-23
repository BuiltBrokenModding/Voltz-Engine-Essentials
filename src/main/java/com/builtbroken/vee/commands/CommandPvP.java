package com.builtbroken.vee.commands;

import com.builtbroken.mc.core.commands.ext.SubCommandWithName;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

/**
 * Created by robert on 2/23/2015.
 */
public class CommandPvP extends SubCommandWithName
{
    public CommandPvP()
    {
        super("pvp");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean handleEntityPlayerCommand(EntityPlayer player, String user, String[] args)
    {
        if (user.equalsIgnoreCase("enable"))
        {
            if (player.getEntityData().hasKey("pvp_enabled") && player.getEntityData().getBoolean("pvp_enabled"))
            {
                player.addChatComponentMessage(new ChatComponentText("You are already enabled for PvP"));
            }
            else
            {
                player.getEntityData().setBoolean("pvp_enabled", true);
                player.addChatComponentMessage(new ChatComponentText("You can now be attacked by players"));
            }
            return true;
        }
        else if (user.equalsIgnoreCase("disable"))
        {
            if (player.getEntityData().hasKey("pvp_enabled") && !player.getEntityData().getBoolean("pvp_enabled"))
            {
                player.addChatComponentMessage(new ChatComponentText("You can no longer be attacked by players"));
            }
            else
            {
                player.getEntityData().setBoolean("pvp_enabled", false);
                player.addChatComponentMessage(new ChatComponentText("PvP disabled"));
            }
            return true;
        }
        return handleConsoleCommand(player, user, args);
    }

    @Override
    public boolean handleConsoleCommand(ICommandSender sender, String user, String[] args)
    {
        EntityPlayer player = getPlayer(sender, user);
        if (player != null)
        {
            if (args.length > 0)
            {
                if (args[0].equalsIgnoreCase("enable"))
                {
                    if (player.getEntityData().hasKey("pvp_enabled") && player.getEntityData().getBoolean("pvp_enabled"))
                    {
                        sender.addChatMessage(new ChatComponentText("PvP is already enabled for this player"));
                    }
                    else
                    {
                        player.getEntityData().setBoolean("pvp_enabled", true);
                        sender.addChatMessage(new ChatComponentText("Enabled"));
                        player.addChatComponentMessage(new ChatComponentText("You can now be attacked by players"));
                    }
                    return true;
                }
                else if (args[0].equalsIgnoreCase("disable"))
                {
                    if (player.getEntityData().hasKey("pvp_enabled") && !player.getEntityData().getBoolean("pvp_enabled"))
                    {
                        sender.addChatMessage(new ChatComponentText("PvP is already disabled for this player"));
                    }
                    else
                    {
                        player.getEntityData().setBoolean("pvp_enabled", false);
                        sender.addChatMessage(new ChatComponentText("Disabled"));
                        player.addChatComponentMessage(new ChatComponentText("You can no longer be attacked by players"));
                    }
                    return true;
                }
            }
        }
        else
        {
            player.addChatComponentMessage(new ChatComponentText("Player is not online, or username is incorrect"));
        }
        return true;
    }

    @SubscribeEvent
    public void onDamage(LivingAttackEvent event)
    {
        if (event.entityLiving instanceof EntityPlayer)
        {
            if (event.entityLiving.getEntityData().hasKey("pvp_enabled") && !event.entityLiving.getEntityData().getBoolean("pvp_enabled"))
            {
                if (event.source.getEntity() instanceof EntityPlayer)
                {
                    if (event.isCancelable())
                    {
                        ((EntityPlayer) event.source.getEntity()).addChatComponentMessage(new ChatComponentText("This player can not be attacked by other players!"));
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}
