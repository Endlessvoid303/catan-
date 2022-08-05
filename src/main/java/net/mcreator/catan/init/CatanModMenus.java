
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catan.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.catan.world.inventory.ShopguiMenu;
import net.mcreator.catan.world.inventory.CatanvillageguiMenu;
import net.mcreator.catan.world.inventory.CatanstartguiMenu;
import net.mcreator.catan.world.inventory.CatanroadguiMenu;
import net.mcreator.catan.world.inventory.CatanbiomeguiMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatanModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<CatanstartguiMenu> CATANSTARTGUI = register("catanstartgui",
			(id, inv, extraData) -> new CatanstartguiMenu(id, inv, extraData));
	public static final MenuType<CatanroadguiMenu> CATANROADGUI = register("catanroadgui",
			(id, inv, extraData) -> new CatanroadguiMenu(id, inv, extraData));
	public static final MenuType<CatanvillageguiMenu> CATANVILLAGEGUI = register("catanvillagegui",
			(id, inv, extraData) -> new CatanvillageguiMenu(id, inv, extraData));
	public static final MenuType<CatanbiomeguiMenu> CATANBIOMEGUI = register("catanbiomegui",
			(id, inv, extraData) -> new CatanbiomeguiMenu(id, inv, extraData));
	public static final MenuType<ShopguiMenu> SHOPGUI = register("shopgui", (id, inv, extraData) -> new ShopguiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
