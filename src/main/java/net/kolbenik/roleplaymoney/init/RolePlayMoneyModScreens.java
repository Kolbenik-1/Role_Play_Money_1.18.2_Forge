
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kolbenik.roleplaymoney.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.kolbenik.roleplaymoney.client.gui.CoinExchangerScreen;
import net.kolbenik.roleplaymoney.client.gui.CoinDepositguiScreen;
import net.kolbenik.roleplaymoney.client.gui.AtmdefaultguiScreen;
import net.kolbenik.roleplaymoney.client.gui.ATMGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RolePlayMoneyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(RolePlayMoneyModMenus.ATMGUI, ATMGUIScreen::new);
			MenuScreens.register(RolePlayMoneyModMenus.COIN_EXCHANGER_GUI, CoinExchangerScreen::new);
			MenuScreens.register(RolePlayMoneyModMenus.ATMDEFAULTGUI, AtmdefaultguiScreen::new);
			MenuScreens.register(RolePlayMoneyModMenus.COIN_DEPOSITGUI, CoinDepositguiScreen::new);
		});
	}
}
