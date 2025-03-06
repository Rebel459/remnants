package net.legacy.remnants.registry;

import net.legacy.remnants.RemnantsConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.item.equipment.trim.TrimPatterns;
import org.jetbrains.annotations.NotNull;

public class RemnantsTrimPatterns {
	public static final ResourceKey<TrimPattern> DESOLATION = create("desolation");

	public static void init() {
	}

	private static @NotNull ResourceKey<TrimPattern> create(String path) {
		return ResourceKey.create(Registries.TRIM_PATTERN, RemnantsConstants.id(path));
	}

	public static void bootstrap(BootstrapContext<TrimPattern> context) {
		TrimPatterns.register(context, RemnantsItems.DESOLATION_ARMOR_TRIM_SMITHING_TEMPLATE, DESOLATION);
	}
}
