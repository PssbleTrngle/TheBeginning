package com.possible_triangle.the_beginning.index;

import static com.possible_triangle.the_beginning.ForgeEntrypoint.REGISTRATE;

import com.possible_triangle.the_beginning.world.feature.ObeliskStructure;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class TBStructures {

    public static final RegistryEntry<StructureType<?>, StructureType<ObeliskStructure>> OBELISK = REGISTRATE.object("obelisk")
            .generic(Registries.STRUCTURE_TYPE, () -> (StructureType<ObeliskStructure>) () -> ObeliskStructure.CODEC)
            .register();

    public static void register() {
        // Load this class
    }

}
