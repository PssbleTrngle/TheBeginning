package com.possible_triangle.the_beginning.data.tags;

import com.possible_triangle.the_beginning.TBConstants;
import com.possible_triangle.the_beginning.index.TBTags;
import com.possible_triangle.the_beginning.index.TBTime;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.world.timeline.Timeline;

public class TBTimelineTags extends KeyTagProvider<Timeline> {

    public TBTimelineTags(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Registries.TIMELINE, registries, TBConstants.MOD_ID);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(TBTags.Timelines.TIMELINES).add(
                TBTime.DAY_TIMELINE
        );
    }
}
