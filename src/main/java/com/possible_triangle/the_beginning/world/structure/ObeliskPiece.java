package com.possible_triangle.the_beginning.world.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.possible_triangle.the_beginning.index.TBStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.ScatteredFeaturePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;

public class ObeliskPiece extends ScatteredFeaturePiece {

    private record Config(BlockStateProvider baseMaterial) {
        public static final String TAG = "config";

        public static final Codec<Config> CODEC = RecordCodecBuilder.create(builder ->
                builder.group(
                        BlockStateProvider.CODEC.fieldOf("base").forGetter(Config::baseMaterial)
                ).apply(builder, Config::new)
        );
    }

    private final Config config;

    public ObeliskPiece(RandomSource random, ChunkPos chunkPos, int size, int height, BlockStateProvider baseMaterial) {
        super(TBStructures.OBELISK_PIECE.get(), chunkPos.getMinBlockX(), 64, chunkPos.getMinBlockZ(), size, height, size, getRandomHorizontalDirection(random));
        this.config = new Config(baseMaterial);
    }

    private ObeliskPiece(CompoundTag nbt) {
        super(TBStructures.OBELISK_PIECE.get(), nbt);
        this.config = Config.CODEC.parse(NbtOps.INSTANCE, nbt.get(Config.TAG)).getOrThrow();
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag nbt) {
        nbt.put(Config.TAG, Config.CODEC.encodeStart(NbtOps.INSTANCE, config).getOrThrow());
    }

    public static ObeliskPiece load(StructurePieceSerializationContext context, CompoundTag nbt) {
        return new ObeliskPiece(nbt);
    }

    @Override
    public void postProcess(WorldGenLevel level, StructureManager structures, ChunkGenerator generator, RandomSource random, BoundingBox bounds, ChunkPos chunk, BlockPos origin) {
        if (updateHeightPositionToLowestGroundHeight(level, 0)) {
            for (int x = 0; x < width; x++) {
                for (int z = 0; z < width; z++) {
                    for (int y = 0; y < height; y++) {
                        var pos = getWorldPos(x, y, z);
                        var state = config.baseMaterial().getState(level, random, pos);
                        level.setBlock(pos, state, 2);
                    }
                }
            }
        }
    }

}
