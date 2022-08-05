
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.catan.block.entity.CatanvillageblockBlockEntity;
import net.mcreator.catan.block.entity.CatanshopBlockEntity;
import net.mcreator.catan.block.entity.CatanbiomeblockBlockEntity;
import net.mcreator.catan.CatanMod;

public class CatanModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CatanMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CATANVILLAGEBLOCK = register("catanvillageblock", CatanModBlocks.CATANVILLAGEBLOCK,
			CatanvillageblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CATANBIOMEBLOCK = register("catanbiomeblock", CatanModBlocks.CATANBIOMEBLOCK,
			CatanbiomeblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CATANSHOP = register("catanshop", CatanModBlocks.CATANSHOP, CatanshopBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
