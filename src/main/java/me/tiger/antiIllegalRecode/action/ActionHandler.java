package me.tiger.antiIllegalRecode.action;

import me.tiger.antiIllegalRecode.AntiIllegalRecode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.stream.Collectors;

public class ActionHandler {

    public static void handle(Player player, ItemStack item) {
        if (item == null || item.getType().isAir()) return; // ignore empty slots

        // Remove illegal item
        player.getInventory().remove(item);
        player.sendMessage("§cIllegal item detected and removed!");

        // Build enchantment string if any
        String enchants = "";
        if (!item.getEnchantments().isEmpty()) {
            enchants = item.getEnchantments().entrySet().stream()
                    .map(e -> e.getKey().getKey().getKey() + ":" + e.getValue())
                    .collect(Collectors.joining(", "));
        }

        // Build coordinates string
        String coords = "X: " + player.getLocation().getBlockX() +
                " Y: " + player.getLocation().getBlockY() +
                " Z: " + player.getLocation().getBlockZ();

        // Send webhook
        AntiIllegalRecode.getInstance().getWebhook().sendMessage(
                "Player: " + player.getName() +
                        " | Item: " + item.getType() +
                        " | Amount: " + item.getAmount() +
                        (enchants.isEmpty() ? "" : " | Enchants: " + enchants) +
                        " | Coords: " + coords
        );

        System.out.println("[AntiIllegalRecode] Handled illegal item from " + player.getName());
    }
}
