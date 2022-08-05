package net.mcreator.catan.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.catan.network.CatanModVariables;
import net.mcreator.catan.init.CatanModGameRules;

public class PricebiomeupgradeProcedure {
	public static void execute(LevelAccessor world) {
		double basic_cost = 0;
		double cost_multiplier = 0;
		double cost_power = 0;
		double total_cost = 0;
		basic_cost = (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMEBASECOST));
		cost_multiplier = (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTMULTIPLIER));
		cost_power = (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTPOWER));
		total_cost = Math.round(CatanModVariables.MapVariables.get(world).tier * cost_multiplier * Math.pow(basic_cost, cost_power));
		CatanModVariables.MapVariables.get(world).biome_upgrade_cost = total_cost;
		CatanModVariables.MapVariables.get(world).syncData(world);
	}
}
