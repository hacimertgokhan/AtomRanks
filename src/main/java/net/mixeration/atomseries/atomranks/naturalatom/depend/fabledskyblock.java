package net.mixeration.atomseries.atomranks.naturalatom.depend;

import com.songoda.skyblock.api.SkyBlockAPI;
import com.songoda.skyblock.api.island.IslandManager;
import net.mixeration.atomseries.atomranks.AtomRanks;
import net.mixeration.atomseries.atomranks.modules.console;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class fabledskyblock {

    public static SkyBlockAPI skyblockapi;
    public static IslandManager islandmanager;

    public static boolean setupSkyBlock() {
        if (AtomRanks.getInstance().getServer().getPluginManager().getPlugin("FabledSkyBlock") == null) {
            Bukkit.getServer().getPluginManager().disablePlugin(AtomRanks.getInstance());
            console.sendMessage("&c(AtomRanks) - &fFabledSkyBlock &cnot found&f.");
            return false;
        } else {
            console.sendMessage("&a(AtomRanks) - &fFabledSkyBlock &afound&f.");
        }
        return false;
    }

    public static double point(Player player) {
        return islandmanager.getIsland(player).getLevel().getPoints();
    }

    public static double level(Player player) {
        return islandmanager.getIsland(player).getLevel().getLevel();
    }

    public static IslandManager getIslandManager() {
        return islandmanager;
    }

}
