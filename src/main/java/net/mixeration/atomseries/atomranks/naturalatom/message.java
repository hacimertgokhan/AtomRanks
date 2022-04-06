package net.mixeration.atomseries.atomranks.naturalatom;

import net.mixeration.atomseries.atomranks.AtomRanks;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class message {

    public static File messageFile;
    public static FileConfiguration messageConfig;

    public static void createMessage() {
        messageFile = new File(AtomRanks.getInstance().getDataFolder(), "messages.yml");
        if (!messageFile.exists()) {
            messageFile.getParentFile().mkdirs();
            AtomRanks.getInstance().saveResource("messages.yml", false);
        }
        messageConfig = new YamlConfiguration();
        try {
            messageConfig.load(messageFile);
        } catch (InvalidConfigurationException | IOException var2) {
            var2.printStackTrace();
        }
    }

    public static FileConfiguration getMessage() {
        return messageConfig;
    }

    public static void saveMessages() {
        AtomRanks.getInstance().getServer().getScheduler().runTask(AtomRanks.getInstance(), () ->{
            File fileKeys = new File(AtomRanks.getInstance().getDataFolder(), "messages.yml");
            try {
                messageConfig.save(fileKeys);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
