
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kolbenik.roleplaymoney.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.kolbenik.roleplaymoney.world.inventory.CoinExchangerMenu;
import net.kolbenik.roleplaymoney.world.inventory.CoinDepositguiMenu;
import net.kolbenik.roleplaymoney.world.inventory.AtmdefaultguiMenu;
import net.kolbenik.roleplaymoney.world.inventory.ATMGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RolePlayMoneyModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<ATMGUIMenu> ATMGUI = register("atmgui", (id, inv, extraData) -> new ATMGUIMenu(id, inv, extraData));
	public static final MenuType<CoinExchangerMenu> COIN_EXCHANGER_GUI = register("coin_exchanger_gui",
			(id, inv, extraData) -> new CoinExchangerMenu(id, inv, extraData));
	public static final MenuType<AtmdefaultguiMenu> ATMDEFAULTGUI = register("atmdefaultgui",
			(id, inv, extraData) -> new AtmdefaultguiMenu(id, inv, extraData));
	public static final MenuType<CoinDepositguiMenu> COIN_DEPOSITGUI = register("coin_depositgui",
			(id, inv, extraData) -> new CoinDepositguiMenu(id, inv, extraData));

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
