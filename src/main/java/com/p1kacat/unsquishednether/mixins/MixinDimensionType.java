package com.p1kacat.unsquishednether.mixins;

import com.p1kacat.unsquishednether.UnsquishedNether;
import com.p1kacat.unsquishednether.UnsquishedNetherConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(DimensionType.class)
public abstract class MixinDimensionType {
    @Shadow
    public abstract ResourceLocation effectsLocation();

    @Inject(method = "coordinateScale", at = @At("RETURN"), cancellable = true)
    private void unsquishednether$modifyWorldScale(CallbackInfoReturnable<Double> cir) {
        if (Objects.equals(this.effectsLocation().toString(), "minecraft:the_nether")) {
            UnsquishedNether.LOGGER.info("Updating Nether coordinate scale");
            cir.setReturnValue((double) UnsquishedNetherConfig.DISTANCE.get());
        }
    }
}
