package me.tiger.antiIllegalRecode.check;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;

public class ItemCheck {

    public static boolean isIllegal(ItemStack item) {

        Material type = item.getType();

        // Unobtainable blocks
        if (type == Material.BEDROCK ||
                type == Material.COMMAND_BLOCK ||
                type == Material.BARRIER ||
                type == Material.STRUCTURE_BLOCK) {
            return true;
        }

        // Over-level enchantments
        for (var entry : item.getEnchantments().entrySet()) {
            if (entry.getValue() > entry.getKey().getMaxLevel()) {
                return true;
            }
        }

        return false;
    }
}
