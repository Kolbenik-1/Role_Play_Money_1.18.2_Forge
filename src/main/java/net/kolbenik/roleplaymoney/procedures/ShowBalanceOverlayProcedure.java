package net.kolbenik.roleplaymoney.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ShowBalanceOverlayProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = BoolArgumentType.getBool(arguments, "show_balance_overlay");
			entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.show_balance_overlay_player = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
