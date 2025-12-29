package me.tiger.antiIllegalRecode.check;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class BlockCheck {

    private static final Set<Material> ILLEGAL_BLOCKS = Set.of(
            Material.BEDROCK,
            Material.COMMAND_BLOCK,
            Material.BARRIER,
            Material.STRUCTURE_BLOCK
    );

    public static boolean isIllegal(ItemStack item) {
        if (item == null) return false;

        if (ILLEGAL_BLOCKS.contains(item.getType())) {
            item.setType(Material.DIRT); // Convert to dirt
            return true;
        }
        return false;
    }
}
