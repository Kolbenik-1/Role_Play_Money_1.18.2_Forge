package net.kolbenik.roleplaymoney.procedures;

import net.minecraft.world.entity.Entity;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;

public class MoneyOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return RolePlayMoneyModVariables.show_balance_overlay && (entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RolePlayMoneyModVariables.PlayerVariables())).show_balance_overlay_player;
	}
}
