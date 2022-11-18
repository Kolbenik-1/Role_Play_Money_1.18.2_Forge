
package net.kolbenik.roleplaymoney.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.kolbenik.roleplaymoney.procedures.Add5MoneyRightclickedProcedure;
import net.kolbenik.roleplaymoney.init.RolePlayMoneyModTabs;

public class Add5MoneyItem extends Item {
	public Add5MoneyItem() {
		super(new Item.Properties().tab(RolePlayMoneyModTabs.TAB_ROLE_PLAY_MONEY).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Add5MoneyRightclickedProcedure.execute(entity);
		return ar;
	}
}
