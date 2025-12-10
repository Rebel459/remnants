package net.legacy.remnants;

import net.fabricmc.api.ModInitializer;
import net.legacy.remnants.registry.RemnantsCreativeInventorySorting;
import net.legacy.remnants.registry.RemnantsItems;
import net.legacy.remnants.registry.RemnantsMobEffects;
import net.legacy.remnants.registry.RemnantsTrimPatterns;
import net.legacy.remnants.sound.RemnantsSounds;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

public class Remnants implements ModInitializer {
	@Override
	public void onInitialize() {
		RemnantsItems.init();
		RemnantsTrimPatterns.init();
		RemnantsCreativeInventorySorting.init();
		RemnantsMobEffects.init();
		RemnantsSounds.init();
	}

    public static final String MOD_ID = "remnants";
	public static @NotNull Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}