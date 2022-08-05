
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatanModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DEBUGMODE = GameRules.register("debugmode", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> BIOMEBASECOST = GameRules.register("biomebasecost", GameRules.Category.PLAYER,
			GameRules.IntegerValue.create(10));
	public static final GameRules.Key<GameRules.IntegerValue> BIOMECOSTMULTIPLIER = GameRules.register("biomecostmultiplier",
			GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.IntegerValue> BIOMECOSTPOWER = GameRules.register("biomecostpower", GameRules.Category.PLAYER,
			GameRules.IntegerValue.create(1));
}
