package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.TBConstants;
import com.possible_triangle.the_beginning.index.TBFeatures;
import com.possible_triangle.the_beginning.world.feature.ObeliskFeatureConfiguration;
import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TBFeatureGen {

    private static final ResourceKey<ConfiguredFeature<?, ?>> OBELISK = TBConstants.createKey(Registries.CONFIGURED_FEATURE, "obelisk");

    public static void placed(BootstrapContext<PlacedFeature> context) {
        var configured = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                ResourceKey.create(Registries.PLACED_FEATURE, OBELISK.identifier()),
                new PlacedFeature(
                        configured.getOrThrow(OBELISK),
                        List.of(
                                BiomeFilter.biome()
                        )
                )
        );
    }

    public static void configured(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(
                OBELISK,
                new ConfiguredFeature<>(
                        TBFeatures.OBELISK.get(),
                        new ObeliskFeatureConfiguration(
                                BlockStateProvider.simple(Blocks.STONE),
                                UniformInt.of(2, 5),
                                UniformInt.of(12, 24)
                        )
                )
        );
    }

}
