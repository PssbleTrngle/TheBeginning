package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.TBConstants;
import com.possible_triangle.the_beginning.data.tags.TBBiomeTags;
import java.util.Set;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = TBConstants.MOD_ID)
public class DataEntrypoint {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();

        var dataDrivenProvider = event.addProvider(new DatapackBuiltinEntriesProvider(
                output,
                event.getLookupProvider(),
                new RegistrySetBuilder()
                        .add(Registries.BIOME, TBBiomeGen::biomes)
                        .add(Registries.PLACED_FEATURE, TBFeatureGen::placed)
                        .add(Registries.CONFIGURED_FEATURE, TBFeatureGen::configured)
                        .add(Registries.STRUCTURE, TBStructureGen::structures)
                        .add(Registries.STRUCTURE_SET, TBStructureGen::structureSets)
                        .add(Registries.DIMENSION_TYPE, TBDimensionGen::dimensionTypes)
                        .add(Registries.LEVEL_STEM, TBDimensionGen::levelStems),
                Set.of(Identifier.DEFAULT_NAMESPACE, TBConstants.MOD_ID)
        ));

        var registries = dataDrivenProvider.getRegistryProvider();

        event.addProvider(new TBBiomeTags(output, registries));
    }

}
