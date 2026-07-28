package com.possible_triangle.the_beginning.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TBFeatureGen {

    public static void placed(BootstrapContext<PlacedFeature> context) {
        var configured = context.lookup(Registries.CONFIGURED_FEATURE);
    }

    public static void configured(BootstrapContext<ConfiguredFeature<?, ?>> context) {

    }

}
