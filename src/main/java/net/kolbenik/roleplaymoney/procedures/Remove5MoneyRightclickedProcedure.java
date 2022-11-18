package net.kolbenik.roleplaymoney.procedures;

import net.minecraft.world.entity.Entity;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;

public class Remove5MoneyRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player >= 5) {
			{
				double _setval = (entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player - 5;
				entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance_player = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
