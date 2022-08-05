package net.mcreator.catan.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.catan.init.CatanModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CandestroybiomeProcedure {
	@SubscribeEvent
	public static void onEntityGrief(EntityMobGriefingEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean debugmode = false;
		if (world.getLevelData().getGameRules().getBoolean(CatanModGameRules.DEBUGMODE) == true) {
			DestroybiomeProcedure.execute(world, x, y, z, entity);
		}
		return world.getLevelData().getGameRules().getBoolean(CatanModGameRules.DEBUGMODE);
	}
}
