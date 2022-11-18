package net.kolbenik.roleplaymoney.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;

import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

public class PayInProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, new BlockPos(x, y, z), 0)).is(ItemTags.create(new ResourceLocation("role_play_money:credit_card")))) {
			if ((entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player >= new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:Amount") ? ((EditBox) guistate.get("text:Amount")).getValue() : "")) {
				(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.putDouble("balance",
								((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
										&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.getDouble("balance") + new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(guistate.containsKey("text:Amount") ? ((EditBox) guistate.get("text:Amount")).getValue() : "")));
				{
					double _setval = (entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(guistate.containsKey("text:Amount") ? ((EditBox) guistate.get("text:Amount")).getValue() : "");
					entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.balance_player = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
