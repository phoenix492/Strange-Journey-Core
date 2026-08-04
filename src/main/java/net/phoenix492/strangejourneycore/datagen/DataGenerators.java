package net.phoenix492.strangejourneycore.datagen;

import net.phoenix492.strangejourneycore.datagen.client.ModBlockstateProvider;
import net.phoenix492.strangejourneycore.datagen.client.ModItemModelProvider;
import net.phoenix492.strangejourneycore.datagen.client.ModLanguageProvider;
import net.phoenix492.strangejourneycore.datagen.client.ModParticleDescriptionProvider;
import net.phoenix492.strangejourneycore.datagen.client.ModSoundDefinitionsProvider;
import net.phoenix492.strangejourneycore.datagen.server.ModDatapackProvider;
import net.phoenix492.strangejourneycore.datagen.server.ModTagProviders;
import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = StrangeJourneyCore.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Dependencies
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        // The item tags provider requires a block tags provider, so we give it a reference. Others can just be inlined.
        BlockTagsProvider blockTagsProvider = new ModTagProviders.ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);

        // Server/Datapack Generators
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModTagProviders.ModItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModTagProviders.ModEntityTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModTagProviders.ModBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModDatapackProvider(packOutput, lookupProvider));

        // Client/Resourcepack Generators
        generator.addProvider(event.includeClient(), new ModBlockstateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModParticleDescriptionProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModSoundDefinitionsProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(packOutput, "en_us"));
    }
}