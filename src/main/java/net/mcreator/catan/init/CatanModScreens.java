
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.catan.client.gui.ShopguiScreen;
import net.mcreator.catan.client.gui.CatanvillageguiScreen;
import net.mcreator.catan.client.gui.CatanstartguiScreen;
import net.mcreator.catan.client.gui.CatanroadguiScreen;
import net.mcreator.catan.client.gui.CatanbiomeguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CatanModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(CatanModMenus.CATANSTARTGUI, CatanstartguiScreen::new);
			MenuScreens.register(CatanModMenus.CATANROADGUI, CatanroadguiScreen::new);
			MenuScreens.register(CatanModMenus.CATANVILLAGEGUI, CatanvillageguiScreen::new);
			MenuScreens.register(CatanModMenus.CATANBIOMEGUI, CatanbiomeguiScreen::new);
			MenuScreens.register(CatanModMenus.SHOPGUI, ShopguiScreen::new);
		});
	}
}
