package net.kolbenik.roleplaymoney.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RolePlayMoneyCommonConfigProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		com.google.gson.JsonObject jsonobject = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coin_config = new com.google.gson.JsonObject();
		com.google.gson.JsonObject balance_overlay = new com.google.gson.JsonObject();
		com.google.gson.JsonObject jsonobject2 = new com.google.gson.JsonObject();
		File file = new File("");
		File file2 = new File("");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "role_play_money-common.json");
		if (!file.exists()) {
			balance_overlay.addProperty("show_balance_overlay_comment1",
					"Set to true, to show the Balance Overlay for ALL Players. For Players, use: /rpm show_balance true/false");
			balance_overlay.addProperty("show_balance_overlay_comment2", " Default: true");
			balance_overlay.addProperty("show_balance_overlay", (true));
			coin_config.addProperty("coin_config_comment", "All values have to be higher than 0");
			coin_config.addProperty("bronze_coin_value_comment", "Default: 1");
			coin_config.addProperty("bronze_coin_value", 1);
			coin_config.addProperty("iron_coin_value_comment", "Default: 16");
			coin_config.addProperty("iron_coin_value", 16);
			coin_config.addProperty("silver_coin_value_comment", "Default: 64");
			coin_config.addProperty("silver_coin_value", 64);
			coin_config.addProperty("gold_coin_value_comment", "Default: 128");
			coin_config.addProperty("gold_coin_value", 128);
			jsonobject.add("balance_overlay", balance_overlay);
			jsonobject.add("coin_config", coin_config);
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(jsonobject));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		file2 = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "role_play_money-common.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				jsonobject2 = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				balance_overlay = jsonobject2.get("balance_overlay").getAsJsonObject();
				coin_config = jsonobject2.get("coin_config").getAsJsonObject();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		RolePlayMoneyModVariables.show_balance_overlay = balance_overlay.get("show_balance_overlay").getAsBoolean();
		if (coin_config.get("bronze_coin_value").getAsDouble() >= 0) {
			RolePlayMoneyModVariables.bronze_coin_value = coin_config.get("bronze_coin_value").getAsDouble();
		}
		if (coin_config.get("iron_coin_value").getAsDouble() >= 0) {
			RolePlayMoneyModVariables.iron_coin_value = coin_config.get("iron_coin_value").getAsDouble();
		}
		if (coin_config.get("silver_coin_value").getAsDouble() >= 0) {
			RolePlayMoneyModVariables.silver_coin_value = coin_config.get("silver_coin_value").getAsDouble();
		}
		if (coin_config.get("gold_coin_value").getAsDouble() >= 0) {
			RolePlayMoneyModVariables.gold_coin_value = coin_config.get("gold_coin_value").getAsDouble();
		}
	}
}
