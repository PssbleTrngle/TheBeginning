package com.possible_triangle.the_beginning.index;

import com.possible_triangle.the_beginning.TBConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.timeline.Timeline;

public class TBTime {

    public static final ResourceKey<WorldClock> CLOCK = TBConstants.createKey(Registries.WORLD_CLOCK, "clock");

    public static final ResourceKey<Timeline> DAY_TIMELINE = TBConstants.createKey(Registries.TIMELINE, "day");

    public static void register() {
        // Load this class
    }

}
