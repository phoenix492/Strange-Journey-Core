package net.phoenix492.replaceme.core;

import net.phoenix492.replaceme.registration.ModBlocks;
import net.phoenix492.replaceme.registration.ModEffects;
import net.phoenix492.replaceme.registration.ModItems;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.slf4j.Logger;

@Mod(ReplaceMe.MODID)
public class ReplaceMe {
    public static final String MODID = "replaceme";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final boolean DEBUG = false;

    public ReplaceMe(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        // Registration
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);

        // Configs
        // modContainer.registerConfig(ModConfig.Type.COMMON, ReplaceMeConfig.COMMON_SPEC);
        // modContainer.registerConfig(ModConfig.Type.SERVER, ReplaceMeConfig.SERVER_SPEC);
        // modContainer.registerConfig(ModConfig.Type.CLIENT, ReplaceMeConfig.CLIENT_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
