package net.phoenix492.strangejourneycore.core;

import net.phoenix492.strangejourneycore.item.SilphScopeItem;
import net.phoenix492.strangejourneycore.registration.ModBlocks;
import net.phoenix492.strangejourneycore.registration.ModEffects;
import net.phoenix492.strangejourneycore.registration.ModItems;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.slf4j.Logger;

@Mod(StrangeJourneyCore.MODID)
public class StrangeJourneyCore {
    public static final String MODID = "strangejourneycore";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final boolean DEBUG = false;

    public StrangeJourneyCore(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        // Registration
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);

        // Event Listening
        SilphScopeItem.registerSpawnListener();

        // Configs
        // modContainer.registerConfig(ModConfig.Type.COMMON, StrangeJourneyCore.COMMON_SPEC);
        // modContainer.registerConfig(ModConfig.Type.SERVER, StrangeJourneyCore.SERVER_SPEC);
        // modContainer.registerConfig(ModConfig.Type.CLIENT, StrangeJourneyCore.CLIENT_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
