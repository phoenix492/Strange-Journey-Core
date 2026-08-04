package net.phoenix492.strangejourneycore.datagen.client;

import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;
import net.phoenix492.strangejourneycore.registration.ModItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StrangeJourneyCore.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SILPH_SCOPE.asItem());
        basicItem(ModItems.WOODEN_PANEL.asItem());
        //basicItem(ModItems.ROCKY_CLUMP.asItem());
    }
}


