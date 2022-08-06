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
		double n1 = 0;
		double n2 = 0;
		if ((world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMEBASECOST)) == 10) {
			CatanModVariables.MapVariables
					.get(world).biome_upgrade_price = (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMEBASECOST))
							* (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTMULTIPLIER))
							* Math.pow(CatanModVariables.MapVariables.get(world).tier,
									(world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTPOWER)));
			CatanModVariables.MapVariables.get(world).syncData(world);
		} else {
			n1 = (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMEBASECOST))
					* (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTMULTIPLIER))
					* Math.pow(CatanModVariables.MapVariables.get(world).tier,
							(world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTPOWER)));
			if (n1 != 10 * (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTMULTIPLIER)) * Math.pow(
					CatanModVariables.MapVariables.get(world).tier, (world.getLevelData().getGameRules().getInt(CatanModGameRules.BIOMECOSTPOWER)))) {
				CatanModVariables.MapVariables.get(world).biome_upgrade_price = n1;
				CatanModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
