package net.mixeration.atomseries.atomranks.commands;

import com.songoda.skyblock.api.island.IslandManager;
import net.mixeration.atomseries.atomranks.AtomRanks;
import net.mixeration.atomseries.atomranks.modules.console;
import net.mixeration.atomseries.atomranks.naturalatom.message;
import net.mixeration.atomseries.atomranks.storage.player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class up implements CommandExecutor {
    public up(AtomRanks atomRanks) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player user = (Player) sender;
            if (command.getName().equalsIgnoreCase("Rankup")) {
                if (args.length == 0) {
                    String ranks = AtomRanks.getInstance().getConfig().getString("Ranks.");
                    // double playerLevel = fabledskyblock.level(user); double upToLevel = AtomRanks.getInstance().getConfig().getInt("Ranks." + ranks + ".level");
                    double playerPoint = com.songoda.skyblock.api.SkyBlockAPI.getIslandManager().getIsland(user).getLevel().getPoints();
                    double upToPoint = AtomRanks.getInstance().getConfig().getDouble(ranks + ".point");
                    int nextRankPriority = AtomRanks.getInstance().getConfig().getInt(ranks + ".nextRankPriority");
                    String rankName = AtomRanks.getInstance().getConfig().getString(ranks + ".name");
                    String group = AtomRanks.getInstance().getConfig().getString(ranks + ".group");
                    int priority = player.getPlayerData().getInt(user.getName() + ".priority");
                    if (IslandManager.hasIsland(user)) {
                        if (playerPoint >= upToPoint) {
                            if (priority == 0) {
                                player.getPlayerData().set(user.getName() + ".priority", nextRankPriority);
                                player.saveData(user);
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessage().getString("messages.rank_up")));
                                for (String commands : AtomRanks.getInstance().getConfig().getStringList(ranks + ".commands")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commands.replace("%player%", user.getName()));
                                }
                                return true;
                            } else if (priority == nextRankPriority) {
                                player.getPlayerData().set(user.getName() + ".priority", nextRankPriority);
                                player.saveData(user);
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessage().getString("messages.rank_up")));
                                for (String commands : AtomRanks.getInstance().getConfig().getStringList(ranks + ".commands")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commands.replace("%player%", user.getName()));
                                }
                                return true;
                            }
                        } else {
                            user.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessage().getString("messages.not_enough_point")));
                        }
                    } else {
                        user.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessage().getString("messages.has_no_island")));
                    }
                }

            }
        } else {
            console.sendMessage(message.getMessage().getString("messages.only_for_players"));
        }
        return true;
    }
}
