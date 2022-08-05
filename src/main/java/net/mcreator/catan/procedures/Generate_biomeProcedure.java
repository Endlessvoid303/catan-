package net.mcreator.catan.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class Generate_biomeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double random_biome = 0;
		random_biome = Mth.nextInt(new Random(), 1, 6);
		if (random_biome == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("catan", "wood_biome"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 3, y - 1, z - 3), new BlockPos(x - 3, y - 1, z - 3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (random_biome == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("catan", "brick_biome"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 3, y - 3, z - 3), new BlockPos(x - 3, y - 3, z - 3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (random_biome == 3) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("catan", "sheep_biome"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 3, y - 1, z - 3), new BlockPos(x - 3, y - 1, z - 3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (random_biome == 4) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("catan", "wheat_biome"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 3, y - 1, z - 3), new BlockPos(x - 3, y - 1, z - 3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (random_biome == 5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("catan", "gold_biome"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 3, y - 2, z - 3), new BlockPos(x - 3, y - 2, z - 3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (random_biome == 6) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("catan", "rock_biome"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 3, y - 3, z - 3), new BlockPos(x - 3, y - 3, z - 3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			if (_ent != null) {
				final int _slotid = 1;
				final ItemStack _setstack = new ItemStack(Blocks.REDSTONE_BLOCK);
				_setstack.setCount(1);
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
		CatanbiomeguiopenProcedure.execute(world, x, y, z);
	}
}
