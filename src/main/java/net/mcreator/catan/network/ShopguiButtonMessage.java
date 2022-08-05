
package net.mcreator.catan.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.catan.world.inventory.ShopguiMenu;
import net.mcreator.catan.procedures.TradeProcedure;
import net.mcreator.catan.procedures.SellwoolProcedure;
import net.mcreator.catan.procedures.SellwoodProcedure;
import net.mcreator.catan.procedures.SellwheatProcedure;
import net.mcreator.catan.procedures.SellstoneProcedure;
import net.mcreator.catan.procedures.SellgoldProcedure;
import net.mcreator.catan.procedures.SellbricksProcedure;
import net.mcreator.catan.procedures.BuywoolProcedure;
import net.mcreator.catan.procedures.BuywoodProcedure;
import net.mcreator.catan.procedures.BuywheatProcedure;
import net.mcreator.catan.procedures.BuystoneProcedure;
import net.mcreator.catan.procedures.BuygoldProcedure;
import net.mcreator.catan.procedures.BuybricksProcedure;
import net.mcreator.catan.CatanMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShopguiButtonMessage {
	private final int buttonID, x, y, z;

	public ShopguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ShopguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ShopguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ShopguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ShopguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SellgoldProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			BuygoldProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			SellwoodProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			BuywoodProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SellstoneProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			BuystoneProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			SellwoolProcedure.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			BuywoolProcedure.execute(world, x, y, z);
		}
		if (buttonID == 8) {

			SellbricksProcedure.execute(world, x, y, z);
		}
		if (buttonID == 9) {

			BuybricksProcedure.execute(world, x, y, z);
		}
		if (buttonID == 10) {

			SellwheatProcedure.execute(world, x, y, z);
		}
		if (buttonID == 11) {

			BuywheatProcedure.execute(world, x, y, z);
		}
		if (buttonID == 12) {

			TradeProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CatanMod.addNetworkMessage(ShopguiButtonMessage.class, ShopguiButtonMessage::buffer, ShopguiButtonMessage::new,
				ShopguiButtonMessage::handler);
	}
}
