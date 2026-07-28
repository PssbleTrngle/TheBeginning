package com.possible_triangle.the_beginning.index;

import com.possible_triangle.the_beginning.TBConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class TBBiomes {

    public static final ResourceKey<Biome> ANCIENT_FLATS = TBConstants.createKey(Registries.BIOME, "ancient_flats");
    public static final ResourceKey<Biome> ANCIENT_PEAKS = TBConstants.createKey(Registries.BIOME, "ancient_peaks");
    public static final ResourceKey<Biome> ANCIENT_OCEAN = TBConstants.createKey(Registries.BIOME, "ancient_ocean");

}
