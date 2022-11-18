
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kolbenik.roleplaymoney.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.kolbenik.roleplaymoney.block.AtmTopBlock;
import net.kolbenik.roleplaymoney.block.ATMBlock;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

public class RolePlayMoneyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RolePlayMoneyMod.MODID);
	public static final RegistryObject<Block> ATM = REGISTRY.register("atm", () -> new ATMBlock());
	public static final RegistryObject<Block> ATM_TOP = REGISTRY.register("atm_top", () -> new AtmTopBlock());
}
