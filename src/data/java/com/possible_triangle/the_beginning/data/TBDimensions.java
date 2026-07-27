package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.api.TBConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class TBDimensions {

    public static void bootstrap(BootstrapContext<LevelStem> context) {
        var types = context.lookup(Registries.DIMENSION_TYPE);
        var biomes = context.lookup(Registries.BIOME);
        var noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
        var type = types.getOrThrow(ResourceKey.create(Registries.DIMENSION_TYPE, TBConstants.DIMENSION_ID));

        context.register(
                ResourceKey.create(Registries.LEVEL_STEM, TBConstants.DIMENSION_ID),
                new LevelStem(
                        type,
                        new NoiseBasedChunkGenerator(
                                new FixedBiomeSource(biomes.getOrThrow(Biomes.PLAINS)),
                                noiseSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD)
                        )
                )
        );
    }

}
