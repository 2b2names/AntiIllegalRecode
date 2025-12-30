package me.tiger.antiIllegalRecode.command;

import me.tiger.antiIllegalRecode.AntiIllegalRecode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage("§cOP only.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUsage: /airecode <enable|disable>");
            return true;
        }

        if (args[0].equalsIgnoreCase("enable")) {
            AntiIllegalRecode.getInstance().setPluginEnabled(true);
            sender.sendMessage("§aAntiIllegalRecode enabled.");
            return true;
        }

        if (args[0].equalsIgnoreCase("disable")) {
            AntiIllegalRecode.getInstance().setPluginEnabled(false);
            sender.sendMessage("§cAntiIllegalRecode disabled.");
            return true;
        }

        return true;
    }
}
