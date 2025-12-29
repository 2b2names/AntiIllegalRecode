package me.tiger.antiIllegalRecode.check;

import org.bukkit.block.BlockState;
import org.bukkit.block.ShulkerBox;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class ItemCheck {

    public static boolean isIllegal(ItemStack item) {
        boolean illegal = false;

        if (StackCheck.isIllegal(item)) illegal = true;
        if (EnchantCheck.isIllegal(item)) illegal = true;
        if (BlockCheck.isIllegal(item)) illegal = true;

        // Recursively check shulker box contents
        if (item.hasItemMeta() && item.getItemMeta() instanceof BlockStateMeta meta) {
            BlockState state = meta.getBlockState();
            if (state instanceof BlockInventoryHolder holder) {
                for (ItemStack nested : holder.getInventory().getContents()) {
                    if (nested != null && isIllegal(nested)) {
                        illegal = true;
                    }
                }
            }
        }

        return illegal;
    }
}
