
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kolbenik.roleplaymoney.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class RolePlayMoneyModTabs {
	public static CreativeModeTab TAB_ROLE_PLAY_MONEY;

	public static void load() {
		TAB_ROLE_PLAY_MONEY = new CreativeModeTab("tabrole_play_money") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(RolePlayMoneyModItems.BLUE_CREDIT_CARD.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
