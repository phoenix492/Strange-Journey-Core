package net.phoenix492.strangejourneycore.datagen.server;

import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiers extends GlobalLootModifierProvider {
    public ModGlobalLootModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, StrangeJourneyCore.MODID);
    }

    @Override
    protected void start() {

    }
}
