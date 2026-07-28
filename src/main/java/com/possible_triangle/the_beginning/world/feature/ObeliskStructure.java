package com.possible_triangle.the_beginning.world.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.possible_triangle.the_beginning.index.TBStructures;
import java.util.Optional;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

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
        return Optional.empty();
    }

    @Override
    public StructureType<?> type() {
        return TBStructures.OBELISK.get();
    }

}
