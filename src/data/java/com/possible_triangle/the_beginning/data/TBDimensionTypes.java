package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.api.TBConstants;
import java.util.Optional;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TimelineTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.dimension.DimensionType;

public class TBDimensionTypes {

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        var timelines = context.lookup(Registries.TIMELINE);
        var clocks = context.lookup(Registries.WORLD_CLOCK);

        context.register(
                ResourceKey.create(Registries.DIMENSION_TYPE, TBConstants.DIMENSION_ID),
                new DimensionType(
                        false,
                        true,
                        false,
                        false,
                        1.0,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        0.02F,
                        new DimensionType.MonsterSettings(
                                UniformInt.of(0, 7),
                                0
                        ),
                        DimensionType.Skybox.OVERWORLD,
                        CardinalLighting.Type.DEFAULT,
                        EnvironmentAttributeMap.EMPTY,
                        // TODO whatever that means
                        timelines.getOrThrow(TimelineTags.IN_OVERWORLD),
                        Optional.of(clocks.getOrThrow(WorldClocks.OVERWORLD))
                )
        );
    }

}
