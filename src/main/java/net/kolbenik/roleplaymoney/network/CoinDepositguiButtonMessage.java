
package net.kolbenik.roleplaymoney.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.kolbenik.roleplaymoney.world.inventory.CoinDepositguiMenu;
import net.kolbenik.roleplaymoney.procedures.RemoveSilverCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.RemoveIronCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.RemoveGoldCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.RemoveBronzeCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.GobackProcedure;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CoinDepositguiButtonMessage {
	private final int buttonID, x, y, z;

	public CoinDepositguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CoinDepositguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CoinDepositguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CoinDepositguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = CoinDepositguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RemoveBronzeCoinProcedure.execute(entity);
		}
		if (buttonID == 1) {

			RemoveIronCoinProcedure.execute(entity);
		}
		if (buttonID == 2) {

			RemoveSilverCoinProcedure.execute(entity);
		}
		if (buttonID == 3) {

			RemoveGoldCoinProcedure.execute(entity);
		}
		if (buttonID == 4) {

			GobackProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		RolePlayMoneyMod.addNetworkMessage(CoinDepositguiButtonMessage.class, CoinDepositguiButtonMessage::buffer, CoinDepositguiButtonMessage::new,
				CoinDepositguiButtonMessage::handler);
	}
}
