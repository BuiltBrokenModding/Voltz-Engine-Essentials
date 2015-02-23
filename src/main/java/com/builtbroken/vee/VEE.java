package com.builtbroken.vee;

import com.builtbroken.mc.core.commands.CommandVE;
import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import com.builtbroken.vee.commands.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;

/**
 * Created by robert on 2/23/2015.
 */
@Mod(modid = VEE.DOMAIN, name = VEE.NAME, version = VEE.VERSION, dependencies = "required-after:VoltzEngine")
public class VEE extends AbstractMod
{
    /**
     * Name of the channel and mod ID.
     */
    public static final String NAME = "Voltz Essentials";
    public static final String DOMAIN = "voltzessentials";
    public static final String PREFIX = DOMAIN + ":";

    /**
     * The version of WatchYourStep.
     */
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;


    @Mod.Instance(DOMAIN)
    public static VEE INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.vee.ClientProxy", serverSide = "com.builtbroken.vee.CommonProxy")
    public static CommonProxy proxy;

    public static ModCreativeTab CREATIVE_TAB;

    public VEE()
    {
        super(DOMAIN);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        CREATIVE_TAB = new ModCreativeTab("vee");
        getManager().setTab(CREATIVE_TAB);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public CommonProxy getProxy()
    {
        return proxy;
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        ICommandManager commandManager = FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager();
        ServerCommandManager serverCommandManager = ((ServerCommandManager) commandManager);
        serverCommandManager.registerCommand(new CommandHome());
        serverCommandManager.registerCommand(new CommandSetHome());
        serverCommandManager.registerCommand(new CommandSetSpawn());
        serverCommandManager.registerCommand(new CommandSpawn());
        CommandVE.INSTANCE.addCommand(new CommandPvP());
    }
}
