package net.mixeration.atomseries.atomranks;

import net.mixeration.atomseries.atomranks.commands.up;
import net.mixeration.atomseries.atomranks.modules.console;
import net.mixeration.atomseries.atomranks.naturalatom.config;
import net.mixeration.atomseries.atomranks.naturalatom.message;
import net.mixeration.atomseries.atomranks.storage.player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.IOException;

import static net.mixeration.atomseries.atomranks.naturalatom.depend.fabledskyblock.setupSkyBlock;
import static net.mixeration.atomseries.atomranks.naturalatom.depend.luckperms.setupLuckPerms;
import static net.mixeration.atomseries.atomranks.naturalatom.depend.vault.*;

public final class AtomRanks extends JavaPlugin {
    private static AtomRanks instance;
    public static synchronized AtomRanks getInstance() {
        return instance;
    }
    public static synchronized void setInstance(AtomRanks mixeration) {
        instance = mixeration;
    }

    public static PluginManager manager = Bukkit.getPluginManager();


    @Override
    public void onEnable() {

        setInstance(this);

        try {
            config.enable();
            message.createMessage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*
            Vault
         */

        if (!setupEconomy()) {
            console.sendMessage("&c(AtomRanks) - &fVault &ceconomy &fnot found !");
            return;
        } else {
            console.sendMessage("&a(AtomRanks) - &fVault &aeconomy &ffound !");
        }
        if(!setupPermissions()) {
            console.sendMessage("&c(AtomRanks) - &fVault &cpermissions &fnot found !");
            return;
        } else {
            console.sendMessage("&a(AtomRanks) - &fVault &apermissions &ffound !");
        }
        if(!setupChat()){
            console.sendMessage("&c(AtomRanks) - &fVault &cchat &fnot found !");
        } else {
            console.sendMessage("&a(AtomRanks) - &fVault &achat &ffound !");
        }

        /*
            FabledSkyBlock
         */

        setupSkyBlock();

        /*
            LuckPerms
         */

        setupLuckPerms();

        /*
            Register
         */


        getCommand("Rankup").setExecutor(new up(this));
        manager.registerEvents(new player(this), this);


    }

    @Override
    public void onDisable() {

        try {
            config.disable();
            message.saveMessages();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
