package net.mcreator.catan.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BiomeShowupgradeProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean returnlogic = false;
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "blocktier") > 4) {
			returnlogic = false;
		} else {
			returnlogic = true;
		}
		return returnlogic;
	}
}
