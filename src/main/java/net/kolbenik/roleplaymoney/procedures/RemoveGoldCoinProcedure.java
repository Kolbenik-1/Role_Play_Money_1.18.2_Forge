package net.kolbenik.roleplaymoney.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;
import net.kolbenik.roleplaymoney.init.RolePlayMoneyModItems;

public class RemoveGoldCoinProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(RolePlayMoneyModItems.GOLD_COIN.get()))
				: false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(RolePlayMoneyModItems.GOLD_COIN.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			{
				double _setval = (entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player + RolePlayMoneyModVariables.gold_coin_value;
				entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance_player = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
