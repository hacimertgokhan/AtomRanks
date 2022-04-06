package net.mixeration.atomseries.atomranks.storage;

import java.io.File;
import java.io.IOException;

import net.mixeration.atomseries.atomranks.AtomRanks;
import net.mixeration.atomseries.atomranks.modules.console;
import net.mixeration.atomseries.atomranks.naturalatom.config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class player implements Listener {
    public static File playerFile;
    public static FileConfiguration playerConfig;

    public player(AtomRanks atomRanks) {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent) throws IOException {

        Player getPlayer = playerJoinEvent.getPlayer();

        playerFile = new File(AtomRanks.getInstance().getDataFolder() + File.separator + "users" + File.separator + getPlayer.getUniqueId() + ".yml");

        if (!playerFile.exists()) {

            playerFile.getParentFile().mkdirs();

            playerFile.createNewFile();

            playerConfig = new YamlConfiguration();

            console.sendMessage("&a(AtomRanks) - &fCreating a data for &b" + getPlayer.getName() + "&f.");

            try {

                playerConfig.load(playerFile);

            } catch (IOException | InvalidConfigurationException var5) {

                var5.printStackTrace();
            }

            saveData(getPlayer);

        }
        if(getPlayerData().getString(getPlayer.getUniqueId().toString()) == null) {
            getPlayerData().set(getPlayer.getName() + ".priority", null);
            getPlayerData().set(getPlayer.getName() + ".priority", "0");
            getPlayerData().set(getPlayer.getName() + ".current-rank", null);
            getPlayerData().set(getPlayer.getName() + ".current-rank", AtomRanks.getInstance().getConfig().getString("atom-ranks.default-group"));
        }

        saveData(getPlayer);

    }

    public static void saveData(Player player) {
        AtomRanks.getInstance().getServer().getScheduler().runTask(AtomRanks.getInstance(), () ->{
            File fileKeys = new File(AtomRanks.getInstance().getDataFolder() + File.separator + "users" + File.separator + player.getUniqueId() + ".yml");
            try {
                playerConfig.save(fileKeys);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static FileConfiguration getPlayerData(){
        return playerConfig;
    }

}

