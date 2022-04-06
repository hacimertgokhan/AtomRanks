package net.mixeration.atomseries.atomranks.naturalatom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.mixeration.atomseries.atomranks.AtomRanks;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class config {

    private static File config;

    public static void enable() throws FileNotFoundException {
        FileConfiguration config = AtomRanks.getInstance().getConfig();
        new File(AtomRanks.getInstance().getDataFolder(), "config.yml");
        AtomRanks.getInstance().saveDefaultConfig();
    }

    public static void disable() throws IOException {
        AtomRanks.getInstance().saveConfig();
    }

}
