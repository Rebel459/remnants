package net.frozenblock.remnants;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public final class RemnantsItems {

    // Items
    public static final Item REMNANTS_KEY = register("remnants_key",
            Item::new,
            new Properties()
    );
    public static final Item OMINOUS_REMNANTS_KEY = register("ominous_remnants_key",
            Item::new,
            new Properties()
    );

    // Discs
    public static final Item MUSIC_DISC_RETOLD = register("music_disc_retold",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(RemnantsJukeboxSongs.RETOLD)
    );
    public static final Item MUSIC_DISC_REFER = register("music_disc_refer",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(RemnantsJukeboxSongs.REFER)
    );

    // Trims
    public static final Item DESOLATION_ARMOR_TRIM_SMITHING_TEMPLATE = register("desolation_armor_trim_smithing_template",
            SmithingTemplateItem::createArmorTrimTemplate,
            new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, RemnantsConstants.id(name)), function, properties);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
