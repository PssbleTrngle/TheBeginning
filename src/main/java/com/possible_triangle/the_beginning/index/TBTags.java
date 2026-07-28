package com.possible_triangle.the_beginning.index;

import static com.possible_triangle.the_beginning.TBConstants.createId;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.timeline.Timeline;

public class TBTags {

    public static final class Biomes {
        public static final TagKey<Biome> HAS_OBELISK = TagKey.create(Registries.BIOME, createId("has_structure/obelisk"));
    }

    public static final class Timelines {
        public static final TagKey<Timeline> TIMELINES = TagKey.create(Registries.TIMELINE, createId("timelines"));
    }

}
