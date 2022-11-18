
package net.kolbenik.roleplaymoney.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.kolbenik.roleplaymoney.world.inventory.CoinExchangerMenu;
import net.kolbenik.roleplaymoney.procedures.GobackProcedure;
import net.kolbenik.roleplaymoney.procedures.AddSilverCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.AddIronCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.AddGoldCoinProcedure;
import net.kolbenik.roleplaymoney.procedures.AddBronzeCoinProcedure;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CoinExchangerButtonMessage {
	private final int buttonID, x, y, z;

	public CoinExchangerButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CoinExchangerButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CoinExchangerButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CoinExchangerButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CoinExchangerMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AddBronzeCoinProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AddIronCoinProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AddSilverCoinProcedure.execute(entity);
		}
		if (buttonID == 3) {

			AddGoldCoinProcedure.execute(entity);
		}
		if (buttonID == 4) {

			GobackProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		RolePlayMoneyMod.addNetworkMessage(CoinExchangerButtonMessage.class, CoinExchangerButtonMessage::buffer, CoinExchangerButtonMessage::new,
				CoinExchangerButtonMessage::handler);
	}
}
