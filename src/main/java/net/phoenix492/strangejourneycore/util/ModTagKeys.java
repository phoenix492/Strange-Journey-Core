package net.phoenix492.strangejourneycore.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTagKeys {
    public static class Items {
        public static final TagKey<Item> ACCESSORIES_FACE_SLOT = createTag("accessories", "face");

        private static TagKey<Item> createTag(String namespace, String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(namespace, name));
        }
    }


}