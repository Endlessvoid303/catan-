package net.mcreator.catan.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catan.init.CatanModBlocks;

public class Place_roadsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
					new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "fill ~1 ~ ~1 ~-1 ~ ~-1 cobblestone");
		world.setBlock(new BlockPos(x, y, z), CatanModBlocks.CATANVILLAGEBLOCK.get().defaultBlockState(), 3);
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			if (_ent != null) {
				final int _slotid = 0;
				final ItemStack _setstack = new ItemStack(CatanModBlocks.CATANSHOP.get());
				_setstack.setCount(1);
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
		if (!(Blocks.GRAVEL == (world.getBlockState(new BlockPos(x + 5, y, z))).getBlock())) {
			world.setBlock(new BlockPos(x + 5, y, z), CatanModBlocks.CATANROADBLOCK.get().defaultBlockState(), 3);
		}
		if (!(Blocks.GRAVEL == (world.getBlockState(new BlockPos(x, y, z + 5))).getBlock())) {
			world.setBlock(new BlockPos(x, y, z + 5), CatanModBlocks.CATANROADBLOCK.get().defaultBlockState(), 3);
		}
		if (!(Blocks.GRAVEL == (world.getBlockState(new BlockPos(x, y, z - 5))).getBlock())) {
			world.setBlock(new BlockPos(x, y, z - 5), CatanModBlocks.CATANROADBLOCK.get().defaultBlockState(), 3);
		}
		if (!(Blocks.GRAVEL == (world.getBlockState(new BlockPos(x - 5, y, z))).getBlock())) {
			world.setBlock(new BlockPos(x - 5, y, z), CatanModBlocks.CATANROADBLOCK.get().defaultBlockState(), 3);
		}
	}
}
