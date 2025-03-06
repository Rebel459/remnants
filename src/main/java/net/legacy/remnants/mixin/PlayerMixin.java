package net.legacy.remnants.mixin;

import net.legacy.remnants.tag.RemnantsItemTags;
import net.legacy.remnants.sound.RemnantsSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Shadow public abstract void playSound(SoundEvent sound, float volume, float pitch);

    @Inject(method = "attack", at = @At(value = "TAIL"))
    private void katanaSwing(Entity target, CallbackInfo ci) {
        Player player = Player.class.cast(this);
        if (player.getWeaponItem().getTags().anyMatch(Predicate.isEqual(RemnantsItemTags.KATANA))) {
            this.playSound(RemnantsSounds.KATANA_SWING, 1, 1);
        }
    }
}
