package net.phoenix492.strangejourneycore.mixin;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import com.enderio.enderio.AlphaWarning;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AlphaWarning.class)
public class ShutUpEnderIoMixin {
    @Inject(method = "playerJoin", at = @At("HEAD"), cancellable = true)
    private static void strangejourneycore$shutUpEnderIo(PlayerEvent.PlayerLoggedInEvent event, CallbackInfo ci) {
        ci.cancel();
    }
}
