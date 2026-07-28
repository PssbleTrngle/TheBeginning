package com.possible_triangle.the_beginning.index;

import static com.possible_triangle.the_beginning.TBConstants.createId;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class TBTags {

    public static final class Biomes {
        public static final TagKey<Biome> HAS_OBELISK = TagKey.create(Registries.BIOME, createId("has_structure/obelisk"));
    }

}
