package com.possible_triangle.the_beginning.index;

import static com.possible_triangle.the_beginning.ForgeEntrypoint.REGISTRATE;

import com.possible_triangle.the_beginning.world.structure.ObeliskPiece;
import com.possible_triangle.the_beginning.world.structure.ObeliskStructure;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class TBStructures {

    public static final RegistryEntry<StructureType<?>, StructureType<ObeliskStructure>> OBELISK = REGISTRATE.object("obelisk")
            .generic(Registries.STRUCTURE_TYPE, () -> (StructureType<ObeliskStructure>) () -> ObeliskStructure.CODEC)
            .register();

    public static final RegistryEntry<StructurePieceType, StructurePieceType> OBELISK_PIECE = REGISTRATE.object("obelisk")
            .generic(Registries.STRUCTURE_PIECE, () -> ObeliskPiece::load)
            .register();

    public static void register() {
        // Load this class
    }

}
