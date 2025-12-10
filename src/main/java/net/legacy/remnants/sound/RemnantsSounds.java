package net.legacy.remnants.sound;

import net.legacy.remnants.Remnants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

public class RemnantsSounds {
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_REFER = registerForHolder("music_disc.refer");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_RETOLD = registerForHolder("music_disc.retold");

	public static final SoundEvent KATANA_SWING = register("katana.swing");
	public static final SoundEvent KATANA_HEAVY_SWING = register("katana.heavy_swing");

	@NotNull
	private static SoundEvent register(@NotNull String string) {
		Identifier identifier = Remnants.id(string);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

    private static Holder.Reference<SoundEvent> registerForHolder(String id) {
        return registerForHolder(Remnants.id(id));
    }

    private static Holder.Reference<SoundEvent> registerForHolder(Identifier id) {
        return registerForHolder(id, id);
    }

    private static Holder.Reference<SoundEvent> registerForHolder(Identifier id, Identifier soundId) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
    }

	public static void init() {}
}
