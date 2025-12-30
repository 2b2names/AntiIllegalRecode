package me.tiger.antiIllegalRecode;

import me.tiger.antiIllegalRecode.listener.InventoryListener;
import me.tiger.antiIllegalRecode.command.ToggleCommand;
import me.tiger.antiIllegalRecode.util.DiscordWebhook;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiIllegalRecode extends JavaPlugin {

    private static AntiIllegalRecode instance;
    private boolean enabled = true;
    private DiscordWebhook webhook;

    @Override
    public void onEnable() {
        instance = this;

        webhook = new DiscordWebhook(":/"); 

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getCommand("airecode").setExecutor(new ToggleCommand());

        getLogger().info("AntiIllegalRecode enabled!");
    }

    public static AntiIllegalRecode getInstance() {
        return instance;
    }

    public boolean isPluginEnabled() {
        return enabled;
    }

    public void setPluginEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public DiscordWebhook getWebhook() {
        return webhook;
    }
}
