package net.frozenblock.remnants;

import net.frozenblock.lib.item.impl.sherd.DecoratedPotPatternRegistryEntrypoint;
import net.frozenblock.trailiertales.TTConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import org.jetbrains.annotations.NotNull;

public class RemnantsDecoratedPotPatternRegistry implements DecoratedPotPatternRegistryEntrypoint {

	@Override
	public void bootstrap(Registry<DecoratedPotPattern> registry) {
		register(registry, "ambush");
		register(registry, "circuit");
	}

	public static void register(@NotNull Registry<DecoratedPotPattern> registry, String sherdName) {
		ResourceLocation location = TTConstants.id(sherdName + "_pottery_pattern");
		DecoratedPotPatternRegistryEntrypoint.register(
			registry,
			ResourceKey.create(Registries.DECORATED_POT_PATTERN, location),
			location
		);
	}

}
