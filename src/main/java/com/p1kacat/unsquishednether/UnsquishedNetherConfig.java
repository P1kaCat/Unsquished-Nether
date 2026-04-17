package com.p1kacat.unsquishednether;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class UnsquishedNetherConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.IntValue DISTANCE;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("general");
        DISTANCE = builder
                .comment("Overworld to Nether coordinate scale. 8 is vanilla.")
                .defineInRange("distance", 8, 1, 1024);
        builder.pop();

        SPEC = builder.build();
    }

    private UnsquishedNetherConfig() {
    }
}
