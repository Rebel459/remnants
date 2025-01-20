package net.frozenblock.remnants;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.frozenblock.remnants.RemnantsConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;

public final class RemnantsItems {
    private RemnantsItems() {}

    public static final Item REMNANTS_KEY = new Item(new Item.Properties());
    public static final Item OMINOUS_REMNANTS_KEY = new Item(new Item.Properties());

    public static final Item MUSIC_DISC_REFER = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(RemnantsJukeboxSongs.REFER));
    public static final Item MUSIC_DISC_RETOLD = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(RemnantsJukeboxSongs.RETOLD));

    public static final Item AMBUSH_POTTERY_SHERD = new Item(new Item.Properties());
    public static final Item CIRCUIT_POTTERY_SHERD = new Item(new Item.Properties());

    public static final Item DESOLATION_ARMOR_TRIM_SMITHING_TEMPLATE = SmithingTemplateItem.createArmorTrimTemplate(
            ResourceKey.create(Registries.TRIM_PATTERN, RemnantsConstants.id("desolation"))
    );

    public static void register() {
        registerItemAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, DESOLATION_ARMOR_TRIM_SMITHING_TEMPLATE, "desolation_armor_trim_smithing_template", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(Items.OMINOUS_TRIAL_KEY, REMNANTS_KEY, "remnants_key", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(REMNANTS_KEY, OMINOUS_REMNANTS_KEY, "ominous_remnants_key", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(Items.MUSIC_DISC_PRECIPICE, MUSIC_DISC_RETOLD, "music_disc_retold", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(MUSIC_DISC_RETOLD, MUSIC_DISC_REFER, "music_disc_refer", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerSherdBefore(Items.ANGLER_POTTERY_SHERD, AMBUSH_POTTERY_SHERD, "ambush_pottery_sherd", CreativeModeTabs.INGREDIENTS);
        registerSherdAfter(Items.BURN_POTTERY_SHERD, CIRCUIT_POTTERY_SHERD, "circuit_pottery_sherd", CreativeModeTabs.INGREDIENTS);
    }

    private static void register(String path, Item item) {
        Registry.register(BuiltInRegistries.ITEM, Remnants.id(path), item);
    }
    @SafeVarargs
    private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        actualRegister(item, path);
        FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
    }

    private static boolean actualRegister(@NotNull Item item, @NotNull String path) {
        if (BuiltInRegistries.ITEM.getOptional(RemnantsConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, RemnantsConstants.id(path), item);
            return true;
        }
        return false;
    }

    @SafeVarargs
    private static void registerSherdBefore(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        registerSherdBefore(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerSherdBefore(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        actualRegisterSherd(item, path);
        FrozenCreativeTabs.addBefore(comparedItem, item, tabVisibility, tabs);
    }

    @SafeVarargs
    private static void registerSherdAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        registerSherdAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerSherdAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        actualRegisterSherd(item, path);
        FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
    }

    private static void actualRegisterSherd(@NotNull Item item, @NotNull String path) {
        if (actualRegister(item, path)) {
            SherdRegistry.register(item, RemnantsConstants.id(path.replace("sherd", "pattern")));
        }
    }

}
