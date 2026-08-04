package net.phoenix492.replaceme.datagen.client;

import net.phoenix492.replaceme.core.ReplaceMe;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ReplaceMe.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}


