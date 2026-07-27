package com.possible_triangle.the_beginning.api;

import net.minecraft.resources.Identifier;

public class TBConstants {

    public static final String MOD_ID = "the_beginning";
    public static final String MOD_NAME = "The Beginning";

    public static Identifier createId(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static final Identifier DIMENSION_ID = createId(MOD_ID);

}
