
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

import net.mcreator.catan.world.inventory.CatanvillageguiMenu;
import net.mcreator.catan.network.CatanvillageguiButtonMessage;
import net.mcreator.catan.CatanMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CatanvillageguiScreen extends AbstractContainerScreen<CatanvillageguiMenu> {
	private final static HashMap<String, Object> guistate = CatanvillageguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CatanvillageguiScreen(CatanvillageguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("catan:textures/catanvillagegui.png");

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
		this.addRenderableWidget(new Button(this.leftPos + 102, this.topPos + 11, 93, 20, new TextComponent("build village"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new CatanvillageguiButtonMessage(0, x, y, z));
				CatanvillageguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 110, this.topPos + 36, 77, 20, new TextComponent("build city"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new CatanvillageguiButtonMessage(1, x, y, z));
				CatanvillageguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 109, this.topPos + 89, 77, 20, new TextComponent("build shop"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new CatanvillageguiButtonMessage(2, x, y, z));
				CatanvillageguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
