package me.tiger.antiIllegalRecode.listener;

import me.tiger.antiIllegalRecode.AntiIllegalRecode;
import me.tiger.antiIllegalRecode.action.ActionHandler;
import me.tiger.antiIllegalRecode.check.ItemCheck;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!AntiIllegalRecode.getInstance().isPluginEnabled()) return;

        if (!(event.getWhoClicked() instanceof Player player)) return;

        ItemStack item = event.getCurrentItem();
        if (item == null) return;

        if (ItemCheck.isIllegal(item)) {
            ActionHandler.handle(player, item);
        }
    }
}
