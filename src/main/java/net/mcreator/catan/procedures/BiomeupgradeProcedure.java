package net.mcreator.catan.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.catan.network.CatanModVariables;

public class BiomeupgradeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putDouble("blocktier", (CatanModVariables.MapVariables.get(world).tier + 1));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		CatanModVariables.MapVariables.get(world).tier = CatanModVariables.MapVariables.get(world).tier + 1;
		CatanModVariables.MapVariables.get(world).syncData(world);
		PricebiomeupgradeProcedure.execute(world);
	}
}
