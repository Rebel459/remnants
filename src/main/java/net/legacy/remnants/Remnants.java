package net.legacy.remnants;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class Remnants implements ModInitializer {
	@Override
	public void onInitialize() {
		RemnantsItems.init();
		RemnantsTrimPatterns.init();
		RemnantsCreativeInventorySorting.init();
		RemnantsMobEffects.init();
		RemnantsSounds.init();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("remnants", path);
	}
}