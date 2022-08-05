
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.catan.item.TierwoolItem;
import net.mcreator.catan.item.TierwoodItem;
import net.mcreator.catan.item.TierstoneItem;
import net.mcreator.catan.item.TierhayItem;
import net.mcreator.catan.item.TiergoldItem;
import net.mcreator.catan.item.TierbrickItem;
import net.mcreator.catan.CatanMod;

public class CatanModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CatanMod.MODID);
	public static final RegistryObject<Item> CATANBASEBLOCK = block(CatanModBlocks.CATANBASEBLOCK, CatanModTabs.TAB_TABCATAN);
	public static final RegistryObject<Item> CATANROADBLOCK = block(CatanModBlocks.CATANROADBLOCK, CatanModTabs.TAB_TABCATAN);
	public static final RegistryObject<Item> CATANVILLAGEBLOCK = block(CatanModBlocks.CATANVILLAGEBLOCK, CatanModTabs.TAB_TABCATAN);
	public static final RegistryObject<Item> CATANBIOMEBLOCK = block(CatanModBlocks.CATANBIOMEBLOCK, CatanModTabs.TAB_TABCATAN);
	public static final RegistryObject<Item> TIERWOOL = REGISTRY.register("tierwool", () -> new TierwoolItem());
	public static final RegistryObject<Item> TIERWOOD = REGISTRY.register("tierwood", () -> new TierwoodItem());
	public static final RegistryObject<Item> TIERHAY = REGISTRY.register("tierhay", () -> new TierhayItem());
	public static final RegistryObject<Item> TIERBRICK = REGISTRY.register("tierbrick", () -> new TierbrickItem());
	public static final RegistryObject<Item> TIERGOLD = REGISTRY.register("tiergold", () -> new TiergoldItem());
	public static final RegistryObject<Item> TIERSTONE = REGISTRY.register("tierstone", () -> new TierstoneItem());
	public static final RegistryObject<Item> CATANSHOP = block(CatanModBlocks.CATANSHOP, CatanModTabs.TAB_TABCATAN);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
