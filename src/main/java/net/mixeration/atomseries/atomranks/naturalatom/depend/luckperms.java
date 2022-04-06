package net.mixeration.atomseries.atomranks.naturalatom.depend;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.data.DataMutateResult;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.InheritanceNode;
import net.mixeration.atomseries.atomranks.AtomRanks;
import net.mixeration.atomseries.atomranks.modules.console;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public class luckperms {

    public static LuckPerms luckPerms;

    public static boolean setupLuckPerms() {
        if (AtomRanks.getInstance().getServer().getPluginManager().getPlugin("LuckPerms") == null) {
            Bukkit.getServer().getPluginManager().disablePlugin(AtomRanks.getInstance());
            console.sendMessage("&c(AtomRanks) - &fLuckPerms &cnot found&f.");
            return false;
        } else {
            console.sendMessage("&a(AtomRanks) - &fLuckPerms &afound&f.");
        }
        return false;
    }

    public static void setGroup(String group, Player player) {
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        InheritanceNode node = InheritanceNode.builder(group).value(true).build();
        DataMutateResult result = user.data().add(node);
    }

    public static void setPrimaryGroup(String group, Player player) {
        UUID uuid = player.getUniqueId();
        User user = luckPerms.getUserManager().getUser(uuid);
        user.setPrimaryGroup(group);
        luckPerms.getUserManager().saveUser(user);
    }


    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }

    public static String getPlayerGroup(Player player, Collection<String> possibleGroups) {
        for (String group : possibleGroups) {
            if (player.hasPermission("group." + group)) {
                return group;
            }
        }
        return null;
    }

}
