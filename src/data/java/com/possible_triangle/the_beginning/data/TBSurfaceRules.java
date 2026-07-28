package com.possible_triangle.the_beginning.data;

import static net.minecraft.data.worldgen.SurfaceRuleData.*;
import static net.minecraft.world.level.levelgen.SurfaceRules.*;

import com.possible_triangle.the_beginning.index.TBBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class TBSurfaceRules {

    static SurfaceRules.RuleSource createSurfaceRules() {
        var mossFloor = ifTrue(isBiome(TBBiomes.ANCIENT_FLATS), makeStateRule(Blocks.MOSS_BLOCK));

        return sequence(
                ifTrue(
                        verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)),
                        makeStateRule(Blocks.BEDROCK)
                ),
                ifTrue(surfaceNoiseAbove(-1.0), mossFloor),
                ifTrue(SurfaceRules.abovePreliminarySurface(), mossFloor)
        );
    }
}
