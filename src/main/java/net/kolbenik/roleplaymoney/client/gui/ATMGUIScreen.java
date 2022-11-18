
package net.kolbenik.roleplaymoney.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.kolbenik.roleplaymoney.world.inventory.ATMGUIMenu;
import net.kolbenik.roleplaymoney.network.RolePlayMoneyModVariables;
import net.kolbenik.roleplaymoney.network.ATMGUIButtonMessage;
import net.kolbenik.roleplaymoney.RolePlayMoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ATMGUIScreen extends AbstractContainerScreen<ATMGUIMenu> {
	private final static HashMap<String, Object> guistate = ATMGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Amount;

	public ATMGUIScreen(ATMGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("role_play_money:textures/screens/atmgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		Amount.render(ms, mouseX, mouseY, partialTicks);
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
		if (Amount.isFocused())
			return Amount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Amount.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "ATM", 79, 3, -12829636);
		this.font.draw(poseStack, "Player Balance:", 5, 27, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(RolePlayMoneyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RolePlayMoneyModVariables.PlayerVariables())).balance_player) + "", 86, 27, -13369600);
		this.font.draw(poseStack, "Card Balance:", 5, 42, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "card")) + "", 86, 41, -39424);
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
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 60, 45, 20, new TextComponent("Deposit"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new ATMGUIButtonMessage(0, x, y, z));
				ATMGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 60, 49, 20, new TextComponent("Withdraw"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new ATMGUIButtonMessage(1, x, y, z));
				ATMGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		Amount = new EditBox(this.font, this.leftPos + 101, this.topPos + 60, 45, 20, new TextComponent(""));
		guistate.put("text:Amount", Amount);
		Amount.setMaxLength(32767);
		this.addWidget(this.Amount);
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 5, 27, 20, new TextComponent("Back"), e -> {
			if (true) {
				RolePlayMoneyMod.PACKET_HANDLER.sendToServer(new ATMGUIButtonMessage(2, x, y, z));
				ATMGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
