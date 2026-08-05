package net.phoenix492.strangejourneycore.registration;

import net.phoenix492.strangejourneycore.item.SilphScopeItem;
import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items MOD_ITEMS = DeferredRegister.createItems(StrangeJourneyCore.MODID);

    public static DeferredItem<Item> WOODEN_PANEL = MOD_ITEMS.register(
        "wooden_panel",
        () -> new Item(new Item.Properties())
    );

    public static DeferredItem<Item> ROCKY_CLUMP = MOD_ITEMS.register(
        "rocky_clump",
        () -> new Item(new Item.Properties())
    );

    public static DeferredItem<SilphScopeItem> SILPH_SCOPE = MOD_ITEMS.register(
        "silph_scope",
        () -> new SilphScopeItem(new Item.Properties()
            .stacksTo(1)
        )
    );

    public static void register(IEventBus eventBus) {
        MOD_ITEMS.register(eventBus);

    }
}