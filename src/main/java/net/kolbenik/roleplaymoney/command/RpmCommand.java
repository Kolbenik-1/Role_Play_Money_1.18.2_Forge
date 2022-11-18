
package net.kolbenik.roleplaymoney.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.kolbenik.roleplaymoney.procedures.ShowBalanceOverlayProcedure;
import net.kolbenik.roleplaymoney.procedures.SetBalanceProcedure;
import net.kolbenik.roleplaymoney.procedures.RemoveBalanceProcedure;
import net.kolbenik.roleplaymoney.procedures.AddBalanceProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class RpmCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("rpm")

				.then(Commands.literal("balance")
						.then(Commands.literal("show").then(Commands.argument("show_balance_overlay", BoolArgumentType.bool()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							ShowBalanceOverlayProcedure.execute(arguments, entity);
							return 0;
						}))).then(Commands.literal("set").then(Commands.argument("player", EntityArgument.player())
								.then(Commands.argument("balance_set", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SetBalanceProcedure.execute(arguments);
									return 0;
								}))))
						.then(Commands.literal("add").then(Commands.argument("player", EntityArgument.player())
								.then(Commands.argument("balance_add", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AddBalanceProcedure.execute(arguments);
									return 0;
								}))))
						.then(Commands.literal("remove").then(Commands.argument("player", EntityArgument.player())
								.then(Commands.argument("balance_remove", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									RemoveBalanceProcedure.execute(arguments);
									return 0;
								}))))));
	}
}
