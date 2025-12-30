package me.tiger.antiIllegalRecode.action;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ActionHandler {

    public static void handle(Player player, ItemStack item) {
        player.getInventory().remove(item);
        String msg = "Illegal item removed from " + player.getName() + ": " + item.getType();
        player.sendMessage("§c" + msg);
        Bukkit.getConsoleSender().sendMessage(msg);
    }
}
