package net.frozenblock.remnants;

import net.frozenblock.remnants.RemnantsConstants;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import org.jetbrains.annotations.NotNull;

public class RemnantsJukeboxSongs {
	public static final ResourceKey<JukeboxSong> REFER = create("refer");
	public static final ResourceKey<JukeboxSong> RETOLD = create("retold");

	public static void init() {
	}

	private static @NotNull ResourceKey<JukeboxSong> create(String path) {
		return ResourceKey.create(Registries.JUKEBOX_SONG, RemnantsConstants.id(path));
	}

	private static void register(
		@NotNull BootstrapContext<JukeboxSong> context,
		ResourceKey<JukeboxSong> registryKey,
		Holder.Reference<SoundEvent> soundEvent,
		int lengthInSeconds,
		int comparatorOutput
	) {
		context.register(
			registryKey,
			new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", registryKey.location())), (float)lengthInSeconds, comparatorOutput)
		);
	}

	public static void bootstrap(BootstrapContext<JukeboxSong> context) {
		register(context, REFER, RemnantsSounds.MUSIC_DISC_REFER, 187, 15);
		register(context, RETOLD, RemnantsSounds.MUSIC_DISC_RETOLD, 219, 9);
	}
}
