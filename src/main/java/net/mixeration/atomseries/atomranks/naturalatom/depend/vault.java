package net.mixeration.atomseries.atomranks.naturalatom.depend;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.mixeration.atomseries.atomranks.AtomRanks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Logger;

public class vault {
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    public static boolean setupEconomy() {
        if (AtomRanks.getInstance().getServer().getPluginManager().getPlugin("Vault") == null) {
            Bukkit.getServer().getPluginManager().disablePlugin(AtomRanks.getInstance());
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = AtomRanks.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = AtomRanks.getInstance().getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = AtomRanks.getInstance().getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }
}
