package com.p1kacat.unsquishednether;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(UnsquishedNether.MOD_ID)
public class UnsquishedNether {
    public static final String MOD_ID = "unsquishednether";
    public static final Logger LOGGER = LogUtils.getLogger();

    public UnsquishedNether(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, UnsquishedNetherConfig.SPEC);
        LOGGER.info("Unsquished Nether initialized");
    }
}
