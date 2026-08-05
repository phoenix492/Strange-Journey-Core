package net.phoenix492.strangejourneycore.registration;

import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StrangeJourneyCore.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HOSTILE_WORLD_CREATIVE_TAB = CREATIVE_MODE_TABS.register(
        "strangejourneycore_creative_tab",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SILPH_SCOPE.asItem()))
            .title(Component.translatable("creativetab.strangejourneycore.strangejourneycore_creative_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.SILPH_SCOPE);
                output.accept(ModItems.WOODEN_PANEL);
                output.accept(ModItems.ROCKY_CLUMP);
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}