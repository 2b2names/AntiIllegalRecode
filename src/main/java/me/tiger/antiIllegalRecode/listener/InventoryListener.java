package me.tiger.antiIllegalRecode.listener;

import me.tiger.antiIllegalRecode.AntiIllegalRecode;
import me.tiger.antiIllegalRecode.action.ActionHandler;
import me.tiger.antiIllegalRecode.check.BlockCheck;
import me.tiger.antiIllegalRecode.check.EnchantCheck;
import me.tiger.antiIllegalRecode.check.ItemCheck;
import me.tiger.antiIllegalRecode.check.StackCheck;
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
        if (player.isOp()) return;

        ItemStack item = event.getCurrentItem();
        if (item == null || item.getType().isAir()) return;

        boolean illegal = false;

        if (ItemCheck.isIllegal(item)) illegal = true;
        if (BlockCheck.isIllegal(item)) illegal = true;
        if (EnchantCheck.isIllegal(item)) illegal = true;
        if (StackCheck.isIllegal(item)) illegal = true;

        if (illegal) {
            ActionHandler.handle(player, item);
        }
    }
}

