package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.TBConstants;
import com.possible_triangle.the_beginning.index.TBTags;
import com.possible_triangle.the_beginning.world.structure.ObeliskConfiguration;
import com.possible_triangle.the_beginning.world.structure.ObeliskStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.Structure.StructureSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class TBStructureGen {

    private static final ResourceKey<Structure> OBELISK = TBConstants.createKey(Registries.STRUCTURE, "obelisk");

    public static void structures(BootstrapContext<Structure> context) {
        var biomes = context.lookup(Registries.BIOME);

        context.register(
                OBELISK,
                new ObeliskStructure(
                        new StructureSettings(biomes.getOrThrow(TBTags.Biomes.HAS_OBELISK)),
                        new ObeliskConfiguration(
                                new WeightedStateProvider(
                                        WeightedList.<BlockState>builder()
                                                .add(Blocks.STONE.defaultBlockState(), 10)
                                                .add(Blocks.ANDESITE.defaultBlockState(), 1)
                                                .build()
                                ),
                                UniformInt.of(5, 9),
                                UniformInt.of(24, 48)
                        )
                )
        );
    }

    public static void structureSets(BootstrapContext<StructureSet> context) {
        var structures = context.lookup(Registries.STRUCTURE);

        context.register(
                TBConstants.createKey(Registries.STRUCTURE_SET, "obelisks"),
                new StructureSet(
                        structures.getOrThrow(OBELISK),
                        new RandomSpreadStructurePlacement(
                                20, 16, RandomSpreadType.LINEAR, 64872
                        )
                )
        );
    }

}
