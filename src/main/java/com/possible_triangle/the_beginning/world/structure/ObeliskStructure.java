package com.possible_triangle.the_beginning.world.structure;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.possible_triangle.the_beginning.index.TBStructures;
import java.util.Optional;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

public class ObeliskStructure extends Structure {

    public static final MapCodec<ObeliskStructure> CODEC = RecordCodecBuilder.mapCodec((i) ->
            i.group(
                    settingsCodec(i),
                    ObeliskConfiguration.CODEC.forGetter(it -> it.config)
            ).apply(i, ObeliskStructure::new)
    );

    private final ObeliskConfiguration config;

    public ObeliskStructure(StructureSettings settings, ObeliskConfiguration config) {
        super(settings);
        this.config = config;
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, builder -> generate(builder, context));
    }

    private void generate(StructurePiecesBuilder builder, GenerationContext context) {
        var random = context.random();
        builder.addPiece(new ObeliskPiece(
                random,
                context.chunkPos(),
                config.size().sample(random),
                config.height().sample(random),
                config.baseMaterial()
        ));
    }

    @Override
    public StructureType<?> type() {
        return TBStructures.OBELISK.get();
    }

}
