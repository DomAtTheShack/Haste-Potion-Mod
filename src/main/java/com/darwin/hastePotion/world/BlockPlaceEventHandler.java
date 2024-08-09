package com.darwin.hastePotion.world;

import com.darwin.hastePotion.player.InventoryHandler;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = Haste.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockPlaceEventHandler {

    InventoryHandler inventoryHandler = new InventoryHandler();

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof Player player) {
            Level world = (Level) event.getLevel();
            BlockPos pos = event.getPos();
            BlockState placedBlockState = event.getPlacedBlock();
            Block placedBlock = placedBlockState.getBlock();

            handleBlockPlacement(player, world, pos, placedBlock);
        }
    }


    private static void handleBlockPlacement(Player player, Level world, BlockPos pos, Block placedBlock) {
        ItemStack itemInHand = player.getMainHandItem();

        // Check if the player has exactly one block left before placing
        if (itemInHand.getItem() instanceof BlockItem && itemInHand.getCount() == 1) {
            // The player is about to place their last block
            loopThroughInventory(player, placedBlock);
        }
    }

    public static void loopThroughInventory(Player player, Block blockPlaced) {
        Inventory inventory = player.getInventory();
        boolean itemFound = false;

        // Loop through hot bar (slots 0-8)
        for (int i = 0; i < 9; i++) {
            Block blockI = getBlockFromItemStack(inventory.getItem(i));
            if(blockI != null &&
                    blockI.equals(blockPlaced) &&
                    i != inventory.selected)
            {

                itemFound = true;

                moveItemInInventory(player, i, inventory.selected);
                break;
            }
        }

        // Loop through main inventory (slots 9-35)
        if(!itemFound)
        {
            for (int i = 9; i < 36; i++)
            {
                Block blockI = getBlockFromItemStack(inventory.getItem(i));
                if(blockI != null && blockI.equals(blockPlaced))
                {
                    moveItemInInventory(player, i, inventory.selected);
                    break;
                }
            }
        }
    }

    public static Block getBlockFromItemStack(@NotNull ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return null;
        }

        if (itemStack.getItem() instanceof BlockItem blockItem) {
            return blockItem.getBlock();
        }

        return null; // Return null if the ItemStack doesn't represent a block
    }

    public static void moveItemInInventory(Player player, int fromSlot, int toSlot) {
        Inventory inventory = player.getInventory();

        ItemStack itemToMove = inventory.getItem(fromSlot);
        ItemStack itemAtDestination = inventory.getItem(toSlot);

        if (itemToMove.getCount() == 1) {
            inventory.setItem(toSlot, itemToMove);
            inventory.setItem(fromSlot, ItemStack.EMPTY);
        } else {
            inventory.setItem(toSlot, itemToMove);
            inventory.setItem(fromSlot, itemAtDestination);
        }

        // Force the update of the player's held item
        player.containerMenu.broadcastChanges();
        player.inventoryMenu.slotsChanged(inventory);
    }
}