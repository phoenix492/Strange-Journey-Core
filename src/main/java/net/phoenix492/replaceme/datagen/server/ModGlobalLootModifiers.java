package net.phoenix492.replaceme.datagen.server;

import net.phoenix492.replaceme.core.ReplaceMe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiers extends GlobalLootModifierProvider {
    public ModGlobalLootModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ReplaceMe.MODID);
    }

    @Override
    protected void start() {

    }
}
