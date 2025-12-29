package me.tiger.antiIllegalRecode.command;

import me.tiger.antiIllegalRecode.AntiIllegalRecode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        if (!player.isOp()) {
            player.sendMessage("§cOnly OPs can use this command!");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("§eUsage: /airecode <enable|disable>");
            return true;
        }

        String arg = args[0].toLowerCase();

        if (arg.equals("enable")) {
            AntiIllegalRecode.getInstance().setPluginEnabled(true);
            player.sendMessage("§aAntiIllegalRecode is now ENABLED!");
        } else if (arg.equals("disable")) {
            AntiIllegalRecode.getInstance().setPluginEnabled(false);
            player.sendMessage("§cAntiIllegalRecode is now DISABLED!");
        } else {
            player.sendMessage("§eUsage: /airecode <enable|disable>");
        }

        return true;
    }
}
