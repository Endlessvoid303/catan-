package net.mcreator.catan.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.catan.network.CatanModVariables;
import net.mcreator.catan.init.CatanModGameRules;

public class TimerProcedure {
	public static void execute(LevelAccessor world) {
		CatanModVariables.ticks = CatanModVariables.ticks + 1;
		if (CatanModVariables.ticks == 200) {
			CatanModVariables.ticks = 0;
			if (world instanceof Level _level)
				_level.getGameRules().getRule(CatanModGameRules.DEBUGMODE).set((true), _level.getServer());
		}
	}
}
