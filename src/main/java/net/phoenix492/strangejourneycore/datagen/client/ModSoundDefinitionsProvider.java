package net.phoenix492.strangejourneycore.datagen.client;

import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, StrangeJourneyCore.MODID, helper);
    }

    @Override
    public void registerSounds() {

    }
}
