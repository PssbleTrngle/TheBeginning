package com.possible_triangle.the_beginning.index;

import static com.possible_triangle.the_beginning.ForgeEntrypoint.REGISTRATE;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class TBBlocks {

    public static final BlockEntry<Block> DAWN_ROCK = REGISTRATE.object("dawn_rock")
            .block(Block::new)
            .simpleItem()
            .register();

    public static void register() {
        // Load this class
    }

}
