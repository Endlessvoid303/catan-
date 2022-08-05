package net.mcreator.catan.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ShowcitybuttonProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean chestabove = false;
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CHEST) {
			chestabove = true;
			GeneratecityProcedure.execute(world, x, y, z, entity);
		} else {
			chestabove = false;
		}
		return chestabove;
	}
}
