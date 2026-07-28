package com.possible_triangle.the_beginning;

import com.possible_triangle.the_beginning.index.TBBlocks;
import com.possible_triangle.the_beginning.index.TBFeatures;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.Registrate;
import net.neoforged.fml.common.Mod;

@Mod(TBConstants.MOD_ID)
public class ForgeEntrypoint {

    public static final AbstractRegistrate<?> REGISTRATE = Registrate.create(TBConstants.MOD_ID);

    public ForgeEntrypoint() {
        TBBlocks.register();
        TBFeatures.register();
    }

}
