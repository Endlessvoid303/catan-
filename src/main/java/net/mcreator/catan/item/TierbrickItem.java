
package net.mcreator.catan.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.catan.init.CatanModTabs;

import java.util.List;

public class TierbrickItem extends Item {
	public TierbrickItem() {
		super(new Item.Properties().tab(CatanModTabs.TAB_TABCATAN).stacksTo(10).rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("tier 1: free"));
		list.add(new TextComponent("tier 2: 20 bricks"));
		list.add(new TextComponent("tier 3: 30 bricks"));
		list.add(new TextComponent("tier 4: 40 bricks"));
		list.add(new TextComponent("tier 5: 50 bricks"));
	}
}
