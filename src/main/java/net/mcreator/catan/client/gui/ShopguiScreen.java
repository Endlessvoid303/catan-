
package net.mcreator.catan.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.catan.world.inventory.ShopguiMenu;
import net.mcreator.catan.network.ShopguiButtonMessage;
import net.mcreator.catan.CatanMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ShopguiScreen extends AbstractContainerScreen<ShopguiMenu> {
	private final static HashMap<String, Object> guistate = ShopguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ShopguiScreen(ShopguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("catan:textures/shopgui.png");

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
		this.font.draw(poseStack, "sell", 104, 57, -12829636);
		this.font.draw(poseStack, "buy", 180, 55, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 30, 77, 20, new TextComponent("trade gold"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(0, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 222, this.topPos + 28, 66, 20, new TextComponent("buy gold"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(1, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 51, 77, 20, new TextComponent("trade wood"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(2, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 222, this.topPos + 49, 66, 20, new TextComponent("buy wood"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(3, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 73, 82, 20, new TextComponent("trade stone"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(4, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 216, this.topPos + 72, 72, 20, new TextComponent("buy stone"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(5, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 95, 77, 20, new TextComponent("trade wool"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(6, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 222, this.topPos + 94, 66, 20, new TextComponent("buy wool"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(7, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 6, 87, 20, new TextComponent("trade bricks"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(8, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 211, this.topPos + 5, 77, 20, new TextComponent("buy bricks"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(9, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 118, 82, 20, new TextComponent("trade wheat"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(10, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 216, this.topPos + 116, 72, 20, new TextComponent("buy wheat"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(11, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 125, this.topPos + 74, 51, 20, new TextComponent("trade"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new ShopguiButtonMessage(12, x, y, z));
				ShopguiButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}));
	}
}
