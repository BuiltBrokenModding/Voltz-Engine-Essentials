package com.builtbroken.vee.logging.block;

import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cow Pi on 7/28/2015.
 */
public class PlayerInteractionEvents
{
    //TODO see if we can get the source of a fake player & the owner of that source
    //TODO log who places machines that effect large areas such as quarries, bores, farms, etc
    //TODO add support for modded items that have a large area of effect such as Tinkers tools, Rotarycraft bedrock tools
    //TODO add logging hooks for explosives from mods like ICBM, including tracking placement
    /**
     * List of players to ignore, designed for ignoring fake players
     */
    public List<String> ignorePlayerList = new ArrayList();
    //TODO add a whitelist and blacklist of areas to log
    //TODO add a whitelist and blacklist of worlds to log
    //TODO generate a different database log per world
    //TODO add flatfile support
    //TODO add mysql database support


    //TODO handle bows
    public void playerUseItemEvent(PlayerUseItemEvent event)
    {
        if (event.entityPlayer != null && !ignorePlayerList.contains(event.entityPlayer.getCommandSenderName()))
        {
            boolean isFakePlayer = event.entityPlayer instanceof FakePlayer;


        }
    }

    public void playerInteractEvent(PlayerInteractEvent event)
    {
        if (event.entityPlayer != null && !ignorePlayerList.contains(event.entityPlayer.getCommandSenderName()))
        {
            boolean isFakePlayer = event.entityPlayer instanceof FakePlayer;
            //TODO addoption to track all interactions
            //TODO see if the interaction causes a change
            //TODO see if a block was broken
            //TODO see if settings were changed on a machine
            //TODO see if items were removed from an inventory
        }
    }

    public void playerOpenContainerEvent(PlayerOpenContainerEvent event)
    {
        if (event.entityPlayer != null && !ignorePlayerList.contains(event.entityPlayer.getCommandSenderName()))
        {
            boolean isFakePlayer = event.entityPlayer instanceof FakePlayer;
            //TODO add player to a tracker to see what the player adds and removes from the container
            //TODO log entries to a custom database for tracking items
        }
    }

    public void onPlayerUseBonemeal(BonemealEvent event)
    {
        if (event.entityPlayer != null && !ignorePlayerList.contains(event.entityPlayer.getCommandSenderName()))
        {
            boolean isFakePlayer = event.entityPlayer instanceof FakePlayer;
            //TODO log as an item interaction event with additional info
            //TODO see if we can track if something grew

        }
    }
}
