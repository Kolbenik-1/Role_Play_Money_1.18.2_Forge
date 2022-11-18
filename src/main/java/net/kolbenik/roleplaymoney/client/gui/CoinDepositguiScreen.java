
package net.kolbenik.roleplaymoney.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.kolbenik.roleplaymoney.world.inventory.CoinDepositguiMenu;
import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;
import net.kolbenik.roleplaymoney.network.CoinDepositguiButtonMessage;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CoinDepositguiScreen extends AbstractContainerScreen<CoinDepositguiMenu> {
	private final static HashMap<String, Object> guistate = CoinDepositguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CoinDepositguiScreen(CoinDepositguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("role_play_money:textures/screens/coin_depositgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Coin Deposit", 51, 3, -12829636);
		this.font.draw(poseStack,
				"Cost: \u00A76" + (int) (RolePlayMoneyModVariables.bronze_coin_value) + "\u00A78, \u00A78"
						+ (int) (RolePlayMoneyModVariables.iron_coin_value) + ", \u00A77" + (int) (RolePlayMoneyModVariables.silver_coin_value)
						+ "\u00A78, \u00A7e" + (int) (RolePlayMoneyModVariables.gold_coin_value) + "",
				6, 70, -12829636);
		this.font.draw(poseStack, "Transfer Coin to Player Balance", 6, 30, -12829636);
		this.font.draw(poseStack, "Player Balance:", 42, 16, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player) + "", 123, 16, -13369600);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 43, 38, 20, new TextComponent("Bronze"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new CoinDepositguiButtonMessage(0, x, y, z));
				CoinDepositguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 47, this.topPos + 43, 38, 20, new TextComponent("Iron"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new CoinDepositguiButtonMessage(1, x, y, z));
				CoinDepositguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 89, this.topPos + 43, 38, 20, new TextComponent("Silver"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new CoinDepositguiButtonMessage(2, x, y, z));
				CoinDepositguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 130, this.topPos + 43, 38, 20, new TextComponent("Gold"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new CoinDepositguiButtonMessage(3, x, y, z));
				CoinDepositguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 6, 28, 20, new TextComponent("Back"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new CoinDepositguiButtonMessage(4, x, y, z));
				CoinDepositguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
