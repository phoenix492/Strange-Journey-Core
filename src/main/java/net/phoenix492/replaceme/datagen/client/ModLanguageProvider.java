package net.phoenix492.replaceme.datagen.client;

import net.phoenix492.replaceme.core.ReplaceMe;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, ReplaceMe.MODID, locale);
    }

    @Override
    protected void addTranslations() {

    }
}
