package net.kolbenik.roleplaymoney.procedures;

import net.minecraft.world.entity.Entity;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;

public class ResetBalanceRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.balance_player = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
