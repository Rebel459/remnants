package net.legacy.remnants.tag;

import net.legacy.remnants.Remnants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class RemnantsItemTags {
    public static final TagKey<Item> KATANA_REPAIR_MATERIALS = bind("katana_repair_materials");
    public static final TagKey<Item> KATANA = bind("katana");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, Remnants.id(path));
    }

}