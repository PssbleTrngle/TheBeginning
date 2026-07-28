package com.possible_triangle.the_beginning.data;

import com.possible_triangle.the_beginning.index.TBTime;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.attribute.modifier.ColorModifier;
import net.minecraft.world.attribute.modifier.FloatModifier;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.timeline.Timeline;

public class TBTimeGen {

    public static void clocks(BootstrapContext<WorldClock> context) {
        context.register(
                TBTime.CLOCK,
                new WorldClock()
        );
    }

    public static void timelines(BootstrapContext<Timeline> context) {
        var clocks = context.lookup(Registries.WORLD_CLOCK);

        context.register(
                TBTime.DAY_TIMELINE,
                Timeline.builder(clocks.getOrThrow(TBTime.CLOCK))
                        .setPeriodTicks(24000 * 10)
                        .addModifierTrack(EnvironmentAttributes.SKY_LIGHT_LEVEL, FloatModifier.MULTIPLY, builder -> {
                            builder.addKeyframe(133, 1F);
                            builder.addKeyframe(1186, 1F);
                            builder.addKeyframe(13670 * 10, 4 / 15F);
                            builder.addKeyframe(22330 * 10, 4 / 15F);
                        })
                        .addModifierTrack(EnvironmentAttributes.SKY_COLOR, ColorModifier.MULTIPLY_RGB, builder -> {
                            builder.addKeyframe(133, 0xff5729);
                            builder.addKeyframe(1000, 0xffa41c);
                            builder.addKeyframe(11867, 0xffffff);
                            builder.addKeyframe(13670 * 10, 0x0f043b);
                            builder.addKeyframe(22330 * 10, 0x0f043b);
                        })
                        .build()
        );
    }

}
