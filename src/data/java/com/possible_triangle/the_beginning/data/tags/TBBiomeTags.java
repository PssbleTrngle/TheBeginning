package com.possible_triangle.the_beginning.data.tags;

import com.possible_triangle.the_beginning.TBConstants;
import com.possible_triangle.the_beginning.index.TBBiomes;
import com.possible_triangle.the_beginning.index.TBTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;

public class TBBiomeTags extends BiomeTagsProvider {

    public TBBiomeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TBConstants.MOD_ID);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(TBTags.Biomes.HAS_OBELISK).add(
                TBBiomes.ANCIENT_FLATS,
                TBBiomes.ANCIENT_PEAKS,
                TBBiomes.ANCIENT_OCEAN
        );
    }
}
