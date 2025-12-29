package me.tiger.antiIllegalRecode.action;

import me.tiger.antiIllegalRecode.AntiIllegalRecode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ActionHandler {

    public static void handle(Player player, ItemStack item) {
        // Example: remove illegal item
        if (item.getType() != null && !item.getType().isAir()) {
            player.getInventory().remove(item);
        }

        player.sendMessage("§cIllegal item detected and removed!");

        // Send webhook notification
        AntiIllegalRecode.getInstance().getWebhook().sendMessage(
                "Player: " + player.getName() +
                        " | Item: " + item.getType() +
                        " | Amount: " + item.getAmount()
        );

        System.out.println("[AntiIllegalRecode] Handled illegal item from " + player.getName());
    }
}
