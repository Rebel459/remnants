package net.legacy.remnants;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class RemnantsItemTags {
    public static final TagKey<Item> KATANA_REPAIR_MATERIALS = bind("katana_repair_materials");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, RemnantsConstants.id(path));
    }

}