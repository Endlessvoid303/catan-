
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.catan.block.CatanvillageblockBlock;
import net.mcreator.catan.block.CatanshopBlock;
import net.mcreator.catan.block.CatanroadblockBlock;
import net.mcreator.catan.block.CatanbiomeblockBlock;
import net.mcreator.catan.block.CatanbaseblockBlock;
import net.mcreator.catan.CatanMod;

public class CatanModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CatanMod.MODID);
	public static final RegistryObject<Block> CATANBASEBLOCK = REGISTRY.register("catanbaseblock", () -> new CatanbaseblockBlock());
	public static final RegistryObject<Block> CATANROADBLOCK = REGISTRY.register("catanroadblock", () -> new CatanroadblockBlock());
	public static final RegistryObject<Block> CATANVILLAGEBLOCK = REGISTRY.register("catanvillageblock", () -> new CatanvillageblockBlock());
	public static final RegistryObject<Block> CATANBIOMEBLOCK = REGISTRY.register("catanbiomeblock", () -> new CatanbiomeblockBlock());
	public static final RegistryObject<Block> CATANSHOP = REGISTRY.register("catanshop", () -> new CatanshopBlock());
}
