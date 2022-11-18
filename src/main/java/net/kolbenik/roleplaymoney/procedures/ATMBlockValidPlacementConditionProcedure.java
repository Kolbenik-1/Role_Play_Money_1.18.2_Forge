package net.kolbenik.roleplaymoney.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.kolbenik.roleplaymoney.init.RolePlayMoneyModBlocks;

public class ATMBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RolePlayMoneyModBlocks.ATM_TOP.get();
	}
}
