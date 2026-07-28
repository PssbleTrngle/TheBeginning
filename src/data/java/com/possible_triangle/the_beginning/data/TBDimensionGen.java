package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.TBConstants;
import com.possible_triangle.the_beginning.index.TBBiomes;
import com.possible_triangle.the_beginning.index.TBBlocks;
import com.possible_triangle.the_beginning.index.TBTags;
import com.possible_triangle.the_beginning.index.TBTime;
import java.util.Optional;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;

public class TBDimensionGen {

    private static final ResourceKey<DimensionType> TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, TBConstants.DIMENSION_ID);

    private static final int MIN_Y = -64;
    private static final int HEIGHT = 384;

    public static void levelStems(BootstrapContext<LevelStem> context) {
        var types = context.lookup(Registries.DIMENSION_TYPE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(
                ResourceKey.create(Registries.LEVEL_STEM, TBConstants.DIMENSION_ID),
                new LevelStem(
                        types.getOrThrow(TYPE),
                        new NoiseBasedChunkGenerator(
                                new FixedBiomeSource(biomes.getOrThrow(TBBiomes.ANCIENT_FLATS)),
                                createNoiseSettings(context)
                        )
                )
        );
    }

    private static Holder<NoiseGeneratorSettings> createNoiseSettings(BootstrapContext<?> context) {
        var settings = new NoiseGeneratorSettings(
                NoiseSettings.create(MIN_Y, HEIGHT, 1, 2),
                TBBlocks.DAWN_ROCK.getDefaultState(),
                Blocks.WATER.defaultBlockState(),
                NoiseRouterData.overworld(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE), false, false),
                TBSurfaceRules.createSurfaceRules(),
                new OverworldBiomeBuilder().spawnTarget(),
                32,
                false,
                true,
                true,
                false
        );

        return Holder.direct(settings);
    }

    public static void dimensionTypes(BootstrapContext<DimensionType> context) {
        var timelines = context.lookup(Registries.TIMELINE);
        var clocks = context.lookup(Registries.WORLD_CLOCK);

        context.register(
                TYPE,
                new DimensionType(
                        false,
                        true,
                        false,
                        false,
                        1.0,
                        MIN_Y,
                        HEIGHT,
                        HEIGHT,
                        BlockTags.INFINIBURN_OVERWORLD,
                        0.02F,
                        new DimensionType.MonsterSettings(
                                UniformInt.of(0, 7),
                                0
                        ),
                        DimensionType.Skybox.OVERWORLD,
                        CardinalLighting.Type.DEFAULT,
                        createEnvironmentMap(),
                        timelines.getOrThrow(TBTags.Timelines.TIMELINES),
                        Optional.of(clocks.getOrThrow(TBTime.CLOCK))
                )
        );
    }

    private static EnvironmentAttributeMap createEnvironmentMap() {
        return EnvironmentAttributeMap.builder()
                .set(EnvironmentAttributes.NETHER_PORTAL_SPAWNS_PIGLINS, false)
                .set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, 0x0a0a0a)
                .set(EnvironmentAttributes.FOG_COLOR, 0xc0d8ff)
                .set(EnvironmentAttributes.SKY_COLOR, 0x78a7ff)
                .build();
    }

}
