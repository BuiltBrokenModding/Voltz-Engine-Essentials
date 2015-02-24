package com.builtbroken.vee.handlers;

import com.builtbroken.mc.lib.transform.vector.Location;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

import java.util.HashMap;

/**
 * Created by robert on 2/23/2015.
 */
public class PlayerTracker
{
    public HashMap<String, Location> lastTickLocations = new HashMap();

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if (event.phase == TickEvent.Phase.END)
        {
            Location last = null;
            if (lastTickLocations.containsKey(event.player.getCommandSenderName()))
                last = lastTickLocations.get(event.player.getCommandSenderName());

            if (last != null && (last.distance(event.player) >= 50 || last.world() != event.player.worldObj))
            {
                event.player.getEntityData().setTag("last_tp_pos", new Location(event.player).toNBT());
            }
        }
        else
        {
            lastTickLocations.put(event.player.getCommandSenderName(), new Location(event.player));
        }
    }
}
