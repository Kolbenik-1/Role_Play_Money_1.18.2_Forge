package net.kolbenik.roleplaymoney.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;
import net.kolbenik.roleplaymoney.init.RolePlayMoneyModItems;

public class AddGoldCoinProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player >= RolePlayMoneyModVariables.gold_coin_value) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(RolePlayMoneyModItems.GOLD_COIN.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				double _setval = (entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player - RolePlayMoneyModVariables.gold_coin_value;
				entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance_player = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
