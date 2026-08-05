package net.phoenix492.strangejourneycore.datagen.client;

import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;
import net.phoenix492.strangejourneycore.registration.ModItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, StrangeJourneyCore.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ROCKY_CLUMP.asItem(), "Rocky Clump");
        add(ModItems.WOODEN_PANEL.asItem(), "Wooden Panel");
        add(ModItems.SILPH_SCOPE.asItem(), "Silph Scope");
        add("creativetab.strangejourneycore.strangejourneycore_creative_tab", "Strange Journey Core");
    }
}
