
package net.kolbenik.roleplaymoney.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.kolbenik.roleplaymoney.init.RolePlayMoneyModTabs;

public class BronzeCoinItem extends Item {
	public BronzeCoinItem() {
		super(new Item.Properties().tab(RolePlayMoneyModTabs.TAB_ROLE_PLAY_MONEY).stacksTo(64).rarity(Rarity.COMMON));
	}
}
