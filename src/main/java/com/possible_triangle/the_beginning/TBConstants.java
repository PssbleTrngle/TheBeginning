package com.possible_triangle.the_beginning;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class TBConstants {

    public static final String MOD_ID = "the_beginning";
    public static final String MOD_NAME = "The Beginning";

    public static Identifier createId(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static <T> ResourceKey<T> createKey(ResourceKey<? extends Registry<T>> registry, String path) {
        return ResourceKey.create(registry, createId(path));
    }

    public static final Identifier DIMENSION_ID = createId(MOD_ID);

}
