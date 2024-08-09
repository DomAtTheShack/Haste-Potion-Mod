package com.darwin.hastePotion.player;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class InventoryHandler {
    public static ItemStack getItemFromInventory(Player player, int slot) {
        return player.getInventory().getItem(slot);
    }

    public static ItemStack getItemFromHotbar(Player player, int hotbarSlot) {
        return player.getInventory().getItem(hotbarSlot);
    }
}