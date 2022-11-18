
package net.kolbenik.roleplaymoney.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.kolbenik.roleplaymoney.init.RolePlayMoneyModTabs;

public class SilverCoinItem extends Item {
	public SilverCoinItem() {
		super(new Item.Properties().tab(RolePlayMoneyModTabs.TAB_ROLE_PLAY_MONEY).stacksTo(48).rarity(Rarity.COMMON));
	}
}
