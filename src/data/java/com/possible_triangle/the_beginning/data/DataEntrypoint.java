package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.api.TBConstants;
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
        var registries = event.getLookupProvider();

        event.addProvider(new DatapackBuiltinEntriesProvider(
                output,
                registries,
                new RegistrySetBuilder()
                        .add(Registries.DIMENSION_TYPE, TBDimensionTypes::bootstrap)
                        .add(Registries.LEVEL_STEM, TBDimensions::bootstrap),
                Set.of(Identifier.DEFAULT_NAMESPACE, TBConstants.MOD_ID)
        ));
    }

}
