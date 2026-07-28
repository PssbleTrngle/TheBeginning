package com.possible_triangle.the_beginning.index;

import static com.possible_triangle.the_beginning.ForgeEntrypoint.REGISTRATE;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.material.MapColor;

public class TBBlocks {

    public static final BlockEntry<? extends RotatedPillarBlock> DAWN_ROCK = REGISTRATE.object("dawn_rock")
            .block(RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(it -> it.mapColor(MapColor.COLOR_ORANGE))
            .blockstate(() -> (context, provider) -> provider.createAxisAlignedPillarBlock(context.get(), TexturedModel.COLUMN))
            .simpleItem()
            .register();

    public static void register() {
        // Load this class
    }

}
