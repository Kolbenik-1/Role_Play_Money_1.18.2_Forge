
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kolbenik.roleplaymoney.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.kolbenik.roleplaymoney.block.entity.AtmTopBlockEntity;
import net.kolbenik.roleplaymoney.block.entity.ATMBlockEntity;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

public class RolePlayMoneyModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			RolePlayMoneyMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ATM = register("atm", RolePlayMoneyModBlocks.ATM, ATMBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ATM_TOP = register("atm_top", RolePlayMoneyModBlocks.ATM_TOP, AtmTopBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
