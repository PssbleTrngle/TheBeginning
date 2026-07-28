package com.possible_triangle.the_beginning.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record ObeliskFeatureConfiguration(BlockStateProvider baseMaterial, IntProvider size, IntProvider height) implements FeatureConfiguration {

    public static final Codec<ObeliskFeatureConfiguration> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    BlockStateProvider.CODEC.fieldOf("base").forGetter(ObeliskFeatureConfiguration::baseMaterial),
                    IntProviders.CODEC.fieldOf("size").forGetter(ObeliskFeatureConfiguration::size),
                    IntProviders.CODEC.fieldOf("height").forGetter(ObeliskFeatureConfiguration::height)
            ).apply(builder, ObeliskFeatureConfiguration::new)
    );

}
