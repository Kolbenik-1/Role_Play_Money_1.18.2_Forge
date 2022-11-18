package net.kolbenik.roleplaymoney.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;
import net.kolbenik.roleplaymoney.init.RolePlayMoneyModItems;
import net.kolbenik.roleplaymoney.init.RolePlayMoneyModBlocks;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemTooltipProcedure {
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == RolePlayMoneyModItems.BRONZE_COIN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent(("Coin value: " + Math.round(RolePlayMoneyModVariables.bronze_coin_value))));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModItems.IRON_COIN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent(("Coin value: " + Math.round(RolePlayMoneyModVariables.iron_coin_value))));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModItems.SILVER_COIN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent(("Coin value: " + Math.round(RolePlayMoneyModVariables.silver_coin_value))));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModItems.GOLD_COIN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent(("Coin value: " + Math.round(RolePlayMoneyModVariables.gold_coin_value))));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.is(ItemTags.create(new ResourceLocation("role_play_money:credit_card")))) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent(("Balance: " + Math.round(itemstack.getOrCreateTag().getDouble("balance")))));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModItems.ADD_5_MONEY.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent("Adds 5 Money to the Player"));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModItems.REMOVE_5_MONEY.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent("Removes 5 Money from the Player"));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModItems.RESET_BALANCE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent("Resets the Balance from the Player"));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
		if (itemstack.getItem() == RolePlayMoneyModBlocks.ATM.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(new TextComponent("Get Acces to yor Credit Card Balance and deposit/withdraw coins from your own Balance"));
			} else {
				tooltip.add(new TextComponent("Press shift to show information"));
			}
		}
	}
}
