package com.possible_triangle.the_beginning.world.structure;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record ObeliskConfiguration(BlockStateProvider baseMaterial, IntProvider size, IntProvider height) {

    public static final MapCodec<ObeliskConfiguration> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    BlockStateProvider.CODEC.fieldOf("base").forGetter(ObeliskConfiguration::baseMaterial),
                    IntProviders.CODEC.fieldOf("size").forGetter(ObeliskConfiguration::size),
                    IntProviders.CODEC.fieldOf("height").forGetter(ObeliskConfiguration::height)
            ).apply(builder, ObeliskConfiguration::new)
    );

}
