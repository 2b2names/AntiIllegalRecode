package me.tiger.antiIllegalRecode;

import me.tiger.antiIllegalRecode.command.ToggleCommand;
import me.tiger.antiIllegalRecode.listener.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiIllegalRecode extends JavaPlugin {

    private static AntiIllegalRecode instance;
    private boolean enabled = true;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        // Register listener
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);

        // Register command
        getCommand("airecode").setExecutor(new ToggleCommand());

        getLogger().info("AntiIllegalRecode enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiIllegalRecode disabled");
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
}
