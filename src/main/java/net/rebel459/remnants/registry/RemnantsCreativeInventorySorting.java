package net.rebel459.remnants.registry;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class RemnantsCreativeInventorySorting {

	public static void init() {
		insertAfterInToolsAndUtilities(Items.MUSIC_DISC_STRAD, RemnantsItems.MUSIC_DISC_RETOLD);
		insertAfterInToolsAndUtilities(Items.MUSIC_DISC_RELIC, RemnantsItems.MUSIC_DISC_REFER);
		insertAfterInIngredients(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, RemnantsItems.DESOLATION_ARMOR_TRIM_SMITHING_TEMPLATE);
		insertAfterInIngredients(Items.OMINOUS_TRIAL_KEY, RemnantsItems.REMNANTS_KEY);
		insertAfterInIngredients(RemnantsItems.REMNANTS_KEY, RemnantsItems.OMINOUS_REMNANTS_KEY);
		insertBeforeInIngredients(Items.ANGLER_POTTERY_SHERD, RemnantsItems.AMBUSH_POTTERY_SHERD);
		insertAfterInIngredients(Items.BURN_POTTERY_SHERD, RemnantsItems.CIRCUIT_POTTERY_SHERD);
		insertBeforeInCombat(Items.MACE, RemnantsItems.KATANA);
	}

	private static void insertAfterInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.insertAfter(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void insertBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.insertBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void insertAfterInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.insertAfter(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void insertBeforeInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.insertBefore(comparedItem, item, CreativeModeTabs.COMBAT);
	}
}
