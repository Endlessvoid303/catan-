
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class CatanModTabs {
	public static CreativeModeTab TAB_TABCATAN;

	public static void load() {
		TAB_TABCATAN = new CreativeModeTab("tabtabcatan") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(CatanModBlocks.CATANBASEBLOCK.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
