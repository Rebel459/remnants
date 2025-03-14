package net.legacy.remnants.registry;

import net.frozenblock.lib.item.impl.sherd.DecoratedPotPatternRegistryEntrypoint;
import net.legacy.remnants.RemnantsConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import org.jetbrains.annotations.NotNull;

public class RemnantsDecoratedPotPatterns implements DecoratedPotPatternRegistryEntrypoint {
    @Override
    public void bootstrap(Registry<DecoratedPotPattern> registry) {
        register(registry, "ambush");
        register(registry, "circuit");
    }

    public static void register(@NotNull Registry<DecoratedPotPattern> registry, String sherdName) {
        ResourceLocation location = RemnantsConstants.id(sherdName + "_pottery_pattern");
        DecoratedPotPatternRegistryEntrypoint.register(
                registry,
                ResourceKey.create(Registries.DECORATED_POT_PATTERN, location),
                location
        );
    }
}