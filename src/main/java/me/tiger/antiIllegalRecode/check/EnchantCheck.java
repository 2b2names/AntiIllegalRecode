package me.tiger.antiIllegalRecode.check;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnchantCheck {

    public static boolean isIllegal(ItemStack item) {
        if (item == null) return false;

        boolean changed = false;

        for (Map.Entry<Enchantment, Integer> entry : item.getEnchantments().entrySet()) {
            Enchantment ench = entry.getKey();
            int level = entry.getValue();

            if (!ench.canEnchantItem(item)) {
                return true; // illegal enchant
            }

            int maxLevel = ench.getMaxLevel();
            if (level > maxLevel) {
                // Clamp to maximum allowed level
                item.addUnsafeEnchantment(ench, maxLevel);
                changed = true;
            }
        }

        return changed;
    }
}
