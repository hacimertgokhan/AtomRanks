package net.mixeration.atomseries.atomranks.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class console {

    public static ConsoleCommandSender itsConsole = Bukkit.getConsoleSender();

    public static void sendMessage(String consoleMessage) {
        itsConsole.sendMessage(ChatColor.translateAlternateColorCodes('&', consoleMessage));
    }

    public static void error(String errorMessage, int errorID) {
        itsConsole.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        itsConsole.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError ID: " + errorID));
        itsConsole.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &7- &f" + errorMessage));
        itsConsole.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
    }


}
