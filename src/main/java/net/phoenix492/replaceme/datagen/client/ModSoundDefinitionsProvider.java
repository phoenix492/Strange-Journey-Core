package net.phoenix492.replaceme.datagen.client;

import net.phoenix492.replaceme.core.ReplaceMe;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, ReplaceMe.MODID, helper);
    }

    @Override
    public void registerSounds() {

    }
}
