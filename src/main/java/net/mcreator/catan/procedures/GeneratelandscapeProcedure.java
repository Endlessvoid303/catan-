package net.mcreator.catan.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catan.init.CatanModBlocks;

public class GeneratelandscapeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Direction direction = Direction.NORTH;
		boolean generate_north = false;
		boolean generate_east = false;
		boolean generate_south = false;
		boolean generate_west = false;
		generate_north = false;
		generate_east = false;
		generate_south = false;
		generate_west = false;
		if ((world.getBlockState(new BlockPos(x, y, z + 5))).getBlock() == CatanModBlocks.CATANVILLAGEBLOCK.get()) {
			direction = Direction.NORTH;
		} else if ((world.getBlockState(new BlockPos(x + 5, y, z))).getBlock() == CatanModBlocks.CATANVILLAGEBLOCK.get()) {
			direction = Direction.EAST;
		} else if ((world.getBlockState(new BlockPos(x, y, z - 5))).getBlock() == CatanModBlocks.CATANVILLAGEBLOCK.get()) {
			direction = Direction.SOUTH;
		} else if ((world.getBlockState(new BlockPos(x - 5, y, z))).getBlock() == CatanModBlocks.CATANVILLAGEBLOCK.get()) {
			direction = Direction.WEST;
		}
		if (direction == Direction.NORTH) {
			generate_east = true;
			generate_west = true;
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "fill ~-1 ~ ~3 ~1 ~ ~-3 gravel");
			Place_roadsProcedure.execute(world, x, y, (z - 5));
		} else if (direction == Direction.SOUTH) {
			generate_east = true;
			generate_west = true;
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "fill ~-1 ~ ~3 ~1 ~ ~-3 gravel");
			Place_roadsProcedure.execute(world, x, y, (z + 5));
		} else if (direction == Direction.WEST) {
			generate_north = true;
			generate_south = true;
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "fill ~-3 ~ ~1 ~3 ~ ~-1 gravel");
			Place_roadsProcedure.execute(world, (x + 5), y, z);
		} else if (direction == Direction.EAST) {
			generate_north = true;
			generate_south = true;
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "fill ~-3 ~ ~1 ~3 ~ ~-1 gravel");
			Place_roadsProcedure.execute(world, (x - 5), y, z);
		}
		if (generate_north == true) {
			Generate_biomeProcedure.execute(world, x, y, (z - 5));
			Generate_biomeProcedure.execute(world, (x + 10), y, (z - 5));
			Generate_biomeProcedure.execute(world, (x - 10), y, (z - 5));
		}
		if (generate_east == true) {
			Generate_biomeProcedure.execute(world, (x + 5), y, (z + 10));
			Generate_biomeProcedure.execute(world, (x + 5), y, (z - 10));
			Generate_biomeProcedure.execute(world, (x + 5), y, z);
		}
		if (generate_south == true) {
			Generate_biomeProcedure.execute(world, x, y, (z + 5));
			Generate_biomeProcedure.execute(world, (x + 10), y, (z + 5));
			Generate_biomeProcedure.execute(world, (x - 10), y, (z + 5));
		}
		if (generate_west == true) {
			Generate_biomeProcedure.execute(world, (x - 5), y, z);
			Generate_biomeProcedure.execute(world, (x - 5), y, (z + 10));
			Generate_biomeProcedure.execute(world, (x - 5), y, (z - 10));
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
