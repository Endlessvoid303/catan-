
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

import net.mcreator.catan.world.inventory.CatanbiomeguiMenu;
import net.mcreator.catan.network.CatanbiomeguiButtonMessage;
import net.mcreator.catan.network.CatanModVariables;
import net.mcreator.catan.CatanMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CatanbiomeguiScreen extends AbstractContainerScreen<CatanbiomeguiMenu> {
	private final static HashMap<String, Object> guistate = CatanbiomeguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CatanbiomeguiScreen(CatanbiomeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("catan:textures/catanbiomegui.png");

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
		this.font.draw(poseStack, "tier " + (CatanModVariables.MapVariables.get(world).tier) + "", 8, 79, -12829636);
		this.font.draw(poseStack, "price: " + (CatanModVariables.MapVariables.get(world).biome_upgrade_cost) + "", 7, 13, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 32, 61, 20, new TextComponent("upgrade"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new CatanbiomeguiButtonMessage(0, x, y, z));
				CatanbiomeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 224, this.topPos + 10, 61, 20, new TextComponent("destroy"), e -> {
			if (true) {
				CatanMod.PACKET_HANDLER.sendToServer(new CatanbiomeguiButtonMessage(1, x, y, z));
				CatanbiomeguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
