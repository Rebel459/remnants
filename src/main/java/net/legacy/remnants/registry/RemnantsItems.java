package net.legacy.remnants.registry;

import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.legacy.remnants.Remnants;
import net.legacy.remnants.item.KatanaItem;
import net.legacy.remnants.sound.RemnantsJukeboxSongs;
import net.legacy.remnants.tag.RemnantsItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public final class RemnantsItems {

    static HolderGetter<Block> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);

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
                    .rarity(Rarity.UNCOMMON)
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

    // Sherds
    public static final Item AMBUSH_POTTERY_SHERD = registerSherd("ambush_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );

    public static final Item CIRCUIT_POTTERY_SHERD = registerSherd("circuit_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );

    // Katana
    public static final KatanaItem KATANA = register("katana",
            KatanaItem::new,
            new Properties()
                    .stacksTo(1)
                    .component(DataComponents.ATTRIBUTE_MODIFIERS, KatanaItem.createAttributes())
                    .enchantable(14)
                    .component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0, 0, List.of(new BlocksAttacks.DamageReduction(135, Optional.empty(), 0F, 0.5F)), BlocksAttacks.ItemDamageFunction.DEFAULT, Optional.empty(), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.empty()))
                    .component(
                            DataComponents.TOOL,
                            new Tool(
                                    List.of(
                                            Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                                            Tool.Rule.overrideSpeed(holderGetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)
                                    ),
                                    1.0F,
                                    2,
                                    false
                            )
                    )
                    .repairable(RemnantsItemTags.KATANA_REPAIR_MATERIALS)
                    .durability(738)
                    .rarity(Rarity.EPIC)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, Remnants.id(name)), function, properties);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

    private static @org.jetbrains.annotations.NotNull <T extends Item> T registerSherd(String name, @org.jetbrains.annotations.NotNull Function<Properties, Item> function, Item.@org.jetbrains.annotations.NotNull Properties properties) {
        T item = (T) Items.registerItem(ResourceKey.create(Registries.ITEM, Remnants.id(name)), function, properties);
        SherdRegistry.register(item, Remnants.id(name.replace("sherd", "pattern")));
        return item;
    }

}
