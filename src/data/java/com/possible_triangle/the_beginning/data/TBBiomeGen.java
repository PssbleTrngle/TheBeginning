package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.index.TBBiomes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeSpecialEffectsBuilder;

public class TBBiomeGen {

    private static Biome.BiomeBuilder basicBuilder() {
        return new Biome.BiomeBuilder()
                .temperature(1F)
                .downfall(0F)
                .specialEffects(BiomeSpecialEffectsBuilder.create(0x3f76e4).build())
                .generationSettings(BiomeGenerationSettings.EMPTY)
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .hasPrecipitation(false);
    }

    public static void biomes(BootstrapContext<Biome> context) {
        context.register(
                TBBiomes.ANCIENT_FLATS,
                basicBuilder()
                        .mobSpawnSettings(new MobSpawnSettings.Builder()
                                .addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(
                                        EntityType.SNIFFER, 2, 4
                                ))
                                .build())
                        .build()
        );

        context.register(
                TBBiomes.ANCIENT_PEAKS,
                basicBuilder().build()
        );

        context.register(
                TBBiomes.ANCIENT_OCEAN,
                basicBuilder().build()
        );
    }

}
