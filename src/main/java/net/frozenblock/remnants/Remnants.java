package net.frozenblock.remnants;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class Remnants implements ModInitializer {
	@Override
	public void onInitialize() {
		RemnantsItems.init();
		RemnantsCreativeInventorySorting.init();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("remnants", path);
	}
}