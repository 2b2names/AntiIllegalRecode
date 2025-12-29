package me.tiger.antiIllegalRecode.check;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class StackCheck {

    public static boolean isIllegal(ItemStack item) {
        if (item == null) return false;

        Material type = item.getType();
        int amount = item.getAmount();

        if (amount < 1) return true; // invalid
        if (amount > type.getMaxStackSize()) return true; // illegal stack

        return false;
    }
}
