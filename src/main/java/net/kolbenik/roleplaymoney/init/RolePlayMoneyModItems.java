
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kolbenik.roleplaymoney.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.kolbenik.roleplaymoney.item.YellowCreditCardItem;
import net.kolbenik.roleplaymoney.item.WhiteCreditCardItem;
import net.kolbenik.roleplaymoney.item.SilverCoinItem;
import net.kolbenik.roleplaymoney.item.ResetBalanceItem;
import net.kolbenik.roleplaymoney.item.Remove5MoneyItem;
import net.kolbenik.roleplaymoney.item.RedCreditCardItem;
import net.kolbenik.roleplaymoney.item.PurpleCreditCardItem;
import net.kolbenik.roleplaymoney.item.PinkCreditCardItem;
import net.kolbenik.roleplaymoney.item.OrangeCreditCardItem;
import net.kolbenik.roleplaymoney.item.MagentaCreditCardItem;
import net.kolbenik.roleplaymoney.item.LimeCreditCardItem;
import net.kolbenik.roleplaymoney.item.LightGrayCreditCardItem;
import net.kolbenik.roleplaymoney.item.LightBlueCreditCardItem;
import net.kolbenik.roleplaymoney.item.IronCoinItem;
import net.kolbenik.roleplaymoney.item.GreenCreditCardItem;
import net.kolbenik.roleplaymoney.item.GrayCreditCardItem;
import net.kolbenik.roleplaymoney.item.GoldCoinItem;
import net.kolbenik.roleplaymoney.item.CyanCreditCardItem;
import net.kolbenik.roleplaymoney.item.CreditCardItem;
import net.kolbenik.roleplaymoney.item.BrownCreditCardItem;
import net.kolbenik.roleplaymoney.item.BronzeCoinItem;
import net.kolbenik.roleplaymoney.item.BlackCreditCardItem;
import net.kolbenik.roleplaymoney.item.Add5MoneyItem;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

public class RolePlayMoneyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RolePlayMoneyMod.MODID);
	public static final RegistryObject<Item> BLUE_CREDIT_CARD = REGISTRY.register("blue_credit_card", () -> new CreditCardItem());
	public static final RegistryObject<Item> ATM = block(RolePlayMoneyModBlocks.ATM, RolePlayMoneyModTabs.TAB_ROLE_PLAY_MONEY);
	public static final RegistryObject<Item> BRONZE_COIN = REGISTRY.register("bronze_coin", () -> new BronzeCoinItem());
	public static final RegistryObject<Item> IRON_COIN = REGISTRY.register("iron_coin", () -> new IronCoinItem());
	public static final RegistryObject<Item> SILVER_COIN = REGISTRY.register("silver_coin", () -> new SilverCoinItem());
	public static final RegistryObject<Item> GOLD_COIN = REGISTRY.register("gold_coin", () -> new GoldCoinItem());
	public static final RegistryObject<Item> ADD_5_MONEY = REGISTRY.register("add_5_money", () -> new Add5MoneyItem());
	public static final RegistryObject<Item> REMOVE_5_MONEY = REGISTRY.register("remove_5_money", () -> new Remove5MoneyItem());
	public static final RegistryObject<Item> RESET_BALANCE = REGISTRY.register("reset_balance", () -> new ResetBalanceItem());
	public static final RegistryObject<Item> GREEN_CREDIT_CARD = REGISTRY.register("green_credit_card", () -> new GreenCreditCardItem());
	public static final RegistryObject<Item> RED_CREDIT_CARD = REGISTRY.register("red_credit_card", () -> new RedCreditCardItem());
	public static final RegistryObject<Item> PURPLE_CREDIT_CARD = REGISTRY.register("purple_credit_card", () -> new PurpleCreditCardItem());
	public static final RegistryObject<Item> ATM_TOP = block(RolePlayMoneyModBlocks.ATM_TOP, RolePlayMoneyModTabs.TAB_ROLE_PLAY_MONEY);
	public static final RegistryObject<Item> WHITE_CREDIT_CARD = REGISTRY.register("white_credit_card", () -> new WhiteCreditCardItem());
	public static final RegistryObject<Item> BLACK_CREDIT_CARD = REGISTRY.register("black_credit_card", () -> new BlackCreditCardItem());
	public static final RegistryObject<Item> BROWN_CREDIT_CARD = REGISTRY.register("brown_credit_card", () -> new BrownCreditCardItem());
	public static final RegistryObject<Item> CYAN_CREDIT_CARD = REGISTRY.register("cyan_credit_card", () -> new CyanCreditCardItem());
	public static final RegistryObject<Item> GRAY_CREDIT_CARD = REGISTRY.register("gray_credit_card", () -> new GrayCreditCardItem());
	public static final RegistryObject<Item> LIGHT_BLUE_CREDIT_CARD = REGISTRY.register("light_blue_credit_card",
			() -> new LightBlueCreditCardItem());
	public static final RegistryObject<Item> LIGHT_GRAY_CREDIT_CARD = REGISTRY.register("light_gray_credit_card",
			() -> new LightGrayCreditCardItem());
	public static final RegistryObject<Item> MAGENTA_CREDIT_CARD = REGISTRY.register("magenta_credit_card", () -> new MagentaCreditCardItem());
	public static final RegistryObject<Item> LIME_CREDIT_CARD = REGISTRY.register("lime_credit_card", () -> new LimeCreditCardItem());
	public static final RegistryObject<Item> ORANGE_CREDIT_CARD = REGISTRY.register("orange_credit_card", () -> new OrangeCreditCardItem());
	public static final RegistryObject<Item> PINK_CREDIT_CARD = REGISTRY.register("pink_credit_card", () -> new PinkCreditCardItem());
	public static final RegistryObject<Item> YELLOW_CREDIT_CARD = REGISTRY.register("yellow_credit_card", () -> new YellowCreditCardItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
